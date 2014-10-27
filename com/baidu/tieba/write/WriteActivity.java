package com.baidu.tieba.write;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginHelper;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.BaobaoSdkDelegate;
import com.baidu.tieba.editortool.EditorInfoContainer;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
import com.baidu.tieba.editortool.TbEditorToolButtonContainer;
import com.baidu.tieba.util.AntiHelper;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class WriteActivity extends BaseActivity implements PopupWindow.OnDismissListener, com.baidu.tbadk.core.voice.o, com.baidu.tieba.util.m, ci {
    private GestureDetector GW;
    private VoiceManager ayo;
    private com.baidu.tieba.location.d ays;
    private String ayx;
    private com.baidu.tieba.model.ar ayz;
    private View bJA;
    private int bJd;
    private View bJt;
    private TextView bJx;
    private ch bJy;
    private ImageView bJz;
    private Toast bTD;
    private AdditionData bTH;
    private RelativeLayout bTI;
    private TextView bTJ;
    private TextView bTK;
    private TextView bTL;
    private RelativeLayout bTN;
    private TextView bTO;
    private View bTP;
    private LiveBroadcastCard bTQ;
    private com.baidu.tieba.view.c bTW;
    private PostPrefixData mPrefixData;
    private WriteData bpv = null;
    private boolean bTu = false;
    private boolean bTv = false;
    private InputMethodManager mInputManager = null;
    private EditText bJr = null;
    private View bJs = null;
    private LinearLayout bJu = null;
    private EditText bJv = null;
    private AlertDialog ayG = null;
    private o bTw = null;
    private FeedBackTopListView bTx = null;
    private String apZ = null;
    private final KeyEvent bTy = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View Js = null;
    private Button bTz = null;
    private TextView bJw = null;
    private TextView avZ = null;
    private DialogInterface.OnCancelListener bCh = null;
    private AlertDialog bTA = null;
    private final Handler mHandler = new Handler();
    private boolean bTB = false;
    private String bTC = null;
    private RelativeLayout mParent = null;
    private String buF = null;
    private com.baidu.tieba.editortool.j bTE = null;
    private TbEditorToolButtonContainer bTF = null;
    private EditorToolComponetContainer are = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private boolean bTG = false;
    private int bTM = 0;
    private HttpMessageListener bTR = new ac(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private final com.baidu.tieba.model.as ayC = new an(this);
    private com.baidu.tieba.location.i ayD = new az(this);
    private View.OnClickListener bTS = new bh(this);
    private CustomMessageListener blU = new bi(this, 2001232);
    private final Runnable bTT = new bj(this);
    private final View.OnClickListener bTU = new bk(this);
    private boolean bTV = true;
    private final View.OnFocusChangeListener bJp = new bl(this);
    private com.baidu.tieba.bubble.t aDr = new bm(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(WriteActivityConfig.class, WriteActivity.class);
        com.baidu.tieba.location.d.Su();
    }

    public void Ew() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this)));
    }

    public void Ex() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this)) {
            showToast(com.baidu.tieba.y.location_system_permission_prompt);
            this.bTE.setLocationInfoViewState(0);
        } else if (!TbadkApplication.m251getInst().getLocationShared()) {
            Ey();
        } else if (this.ays.St()) {
            Ew();
        } else {
            this.ays.dx(false);
            this.bTE.setLocationInfoViewState(1);
            this.ays.Sr();
        }
    }

    private void Ey() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.aX(com.baidu.tieba.y.location_app_permission_prompt).a(com.baidu.tieba.y.isopen, new ad(this)).b(com.baidu.tieba.y.cancel, new ae(this)).kT();
        aVar.kW();
    }

    public int afq() {
        int selectionEnd = this.bJv.getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) this.bJv.getText().getSpans(0, this.bJv.getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = this.bJv.getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = this.bJv.getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    public void afr() {
        if (!this.bTV) {
            this.bTF.Be();
        } else {
            this.bTF.Bf();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(this);
        this.are.BT();
        if (this.bTW != null && this.bpv != null && this.bpv.getLiveCardData() != null) {
            new Handler().postDelayed(new af(this, new Date(this.bpv.getLiveCardData().getStartTime() * 1000)), 100L);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.are.BR();
        getVoiceManager().onStop(this);
        getWindow().setSoftInputMode(18);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BdLog.addLogPackage(WriteActivity.class.getPackage().getName());
        super.onCreate(bundle);
        registerListener(this.blU);
        this.GW = new GestureDetector(this, new bn(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        d(bundle);
        initUI();
        afv();
        if (this.bTH == null) {
            Ez();
        }
    }

    private void Ez() {
        if (this.ays.Sv()) {
            if (this.ays.St()) {
                this.bTE.j(2, com.baidu.tieba.location.c.So().getLocationData().Sl());
                return;
            }
            this.bTE.setLocationInfoViewState(1);
            this.ays.Sr();
            return;
        }
        this.bTE.setLocationInfoViewState(0);
    }

    public void aca() {
        if (this.ayz != null) {
            this.ayz.cancelLoadData();
        }
        if (this.bTw != null) {
            this.bTw.cancelLoadData();
        }
        if (this.ays != null) {
            this.ays.cancelLoadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        aca();
        afE();
        super.onDestroy();
        getVoiceManager().onDestory(this);
    }

    public void afs() {
        if (this.bpv != null && this.bpv.getType() == 2 && this.bTB) {
            finish();
        } else if (this.bpv == null) {
            finish();
        } else {
            this.bpv.setTitle(this.bJr.getText().toString());
            this.bpv.setContent(this.bJv.getText().toString());
            int type = this.bpv.getType();
            if (this.bpv.getHaveDraft() && com.baidu.adp.lib.util.l.aA(this.bpv.getTitle()) && com.baidu.adp.lib.util.l.aA(this.bpv.getContent()) && !this.bpv.isHasImages()) {
                if (type == 0) {
                    if (this.bpv.getLiveCardData() == null) {
                        com.baidu.tieba.util.l.a(this.bpv.getForumId(), (WriteData) null);
                    } else {
                        com.baidu.tieba.util.l.a(this.bpv.getLiveCardData().getGroupId(), (WriteData) null);
                    }
                } else if (type == 1) {
                    com.baidu.tieba.util.l.b(this.bpv.getThreadId(), (WriteData) null);
                }
            } else if (type == 0) {
                if (this.bpv.getLiveCardData() == null) {
                    com.baidu.tieba.util.l.a(this.bpv.getForumId(), this.bpv);
                } else {
                    com.baidu.tieba.util.l.a(this.bpv.getLiveCardData().getGroupId(), this.bpv);
                }
            } else if (type == 1) {
                com.baidu.tieba.util.l.b(this.bpv.getThreadId(), this.bpv);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bJy != null && this.bJy.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.bJy, this);
                return true;
            } else if (this.are.BB()) {
                this.bTF.Bg();
                this.are.BC();
                return true;
            } else {
                aca();
                afs();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(i);
        com.baidu.tbadk.core.util.aw.f(this.bJw, i);
        afr();
        com.baidu.tbadk.core.util.aw.i(this.bJs, com.baidu.tieba.s.write_line1);
        com.baidu.tbadk.core.util.aw.i(this.bJt, com.baidu.tieba.s.write_line1);
        com.baidu.tbadk.core.util.aw.i((View) this.bJr, com.baidu.tieba.s.write_title_bg);
        if (TextUtils.isEmpty(this.apZ)) {
            com.baidu.tbadk.core.util.aw.i((View) this.bJv, com.baidu.tieba.s.write_content_bg);
        }
        int color = com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.cp_cont_e);
        this.bTF.changeSkinType(i);
        this.bJr.setTextColor(color);
        this.bJv.setTextColor(color);
        a(this.bJr, color2);
        a(this.bJv, color2);
        aci();
        this.are.onChangeSkinType(i);
        this.bTE.sB();
    }

    private void a(EditText editText, int i) {
        Editable text = editText.getText();
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        editText.setText((CharSequence) null);
        editText.setHintTextColor(i);
        editText.setText(text);
        editText.setSelection(selectionStart, selectionEnd);
    }

    private void initUI() {
        setContentView(com.baidu.tieba.w.write_activity);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.Js = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.avZ = this.mNavigationBar.setTitleText("");
        this.bTz = (Button) findViewById(com.baidu.tieba.v.btn_image_problem);
        this.bJw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.y.send));
        this.bJw.setOnFocusChangeListener(this.bJp);
        addGlobalLayoutListener();
        this.bTx = (FeedBackTopListView) findViewById(com.baidu.tieba.v.feedback_top_list);
        this.mParent = (RelativeLayout) findViewById(com.baidu.tieba.v.parent);
        this.bJs = findViewById(com.baidu.tieba.v.interval_view);
        this.bJt = findViewById(com.baidu.tieba.v.prefix_interval_view);
        ach();
        this.mHandler.postDelayed(this.bTT, 200L);
        acj();
        if (this.bTu || this.bTv) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.httpNet.a.mT().hasImageProblem()) {
                findViewById(com.baidu.tieba.v.ll_image_problem).setVisibility(0);
            } else {
                findViewById(com.baidu.tieba.v.ll_image_problem).setVisibility(8);
            }
        }
        this.bJu = (LinearLayout) findViewById(com.baidu.tieba.v.post_content_container);
        this.bJu.setDrawingCacheEnabled(false);
        this.bJu.setOnClickListener(new ag(this));
        this.Js.setOnFocusChangeListener(this.bJp);
        this.Js.setOnClickListener(new ah(this));
        this.bTz.setOnClickListener(new ai(this));
        this.bTE = new com.baidu.tieba.editortool.j((EditorInfoContainer) findViewById(com.baidu.tieba.v.write_editor_info));
        this.bTE.g(this.bTS);
        if (this.bTH != null) {
            this.bTE.destroy();
        }
        afB();
        afy();
        afw();
        if (!TbadkApplication.m251getInst().isBaobaoShouldOpen() || this.bTH != null) {
            this.bTF.CF();
        }
        if (this.bpv.getType() == 0) {
            if (this.bTu || this.bTv) {
                this.bTF.CF();
                this.avZ.setText(com.baidu.tieba.y.feedback);
            } else {
                this.avZ.setText(com.baidu.tieba.y.post_new_thread);
            }
            this.bJr.setVisibility(0);
            this.bJv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
        } else {
            this.avZ.setText(com.baidu.tieba.y.send_reply);
            this.bJv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
            this.bJr.setVisibility(8);
        }
        afx();
        afD();
        f(afF());
        afr();
        afu();
        acg();
        aft();
        aci();
        if (this.bpv.getLiveCardData() == null) {
            ShowSoftKeyPad(this.mInputManager, this.bJr);
        }
    }

    private void aft() {
        this.bTN = (RelativeLayout) findViewById(com.baidu.tieba.v.live_time_rel);
        this.bTO = (TextView) findViewById(com.baidu.tieba.v.live_tiem_show);
        this.bTP = findViewById(com.baidu.tieba.v.interval_view2);
        this.bTQ = (LiveBroadcastCard) findViewById(com.baidu.tieba.v.live_anchor_card);
        this.bTN.setOnClickListener(new aj(this));
        this.bTN.setOnTouchListener(new ak(this));
        if (this.bpv.getLiveCardData() != null) {
            this.bTN.setVisibility(0);
            this.bTP.setVisibility(0);
            this.bTQ.setVisibility(0);
            this.bTQ.setClickable(false);
            this.bTO.setText(com.baidu.tbadk.core.util.ay.k(this.bpv.getLiveCardData().getStartTime() * 1000));
            this.bTQ.setData(this.bpv.getLiveCardData());
            return;
        }
        this.bTN.setVisibility(8);
        this.bTP.setVisibility(8);
        this.bTQ.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if ((dialog instanceof com.baidu.tieba.view.c) && this.bpv.getLiveCardData() != null) {
            Date date = new Date(this.bpv.getLiveCardData().getStartTime() * 1000);
            ((com.baidu.tieba.view.c) dialog).updateTime(date.getHours(), date.getMinutes());
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.bTW = new com.baidu.tieba.view.c(this, new al(this), new Date().getHours(), new Date().getMinutes(), false);
        this.bTW.setTitle(com.baidu.tieba.y.no_disturb_start_time);
        this.bTW.setButton(-1, getString(com.baidu.tieba.y.alert_yes_button), this.bTW);
        this.bTW.setButton(-2, getString(com.baidu.tieba.y.alert_no_button), this.bTW);
        return this.bTW;
    }

    private void afu() {
        this.bTI = (RelativeLayout) findViewById(com.baidu.tieba.v.addition_container);
        this.bTJ = (TextView) findViewById(com.baidu.tieba.v.addition_create_time);
        this.bTK = (TextView) findViewById(com.baidu.tieba.v.addition_last_time);
        this.bTL = (TextView) findViewById(com.baidu.tieba.v.addition_last_content);
        if (this.bTH != null) {
            this.bTI.setVisibility(0);
            this.bTJ.setText(String.valueOf(getString(com.baidu.tieba.y.write_addition_create)) + com.baidu.tbadk.core.util.ay.j(this.bTH.getCreateTime() * 1000));
            if (this.bTH.getAlreadyCount() == 0) {
                this.bTK.setVisibility(8);
            } else {
                this.bTK.setText(String.valueOf(getString(com.baidu.tieba.y.write_addition_last)) + com.baidu.tbadk.core.util.ay.j(this.bTH.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.bTH.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.bTL.setText(lastAdditionContent);
            } else {
                this.bTL.setVisibility(8);
            }
            this.bJv.setHint(String.format(getString(com.baidu.tieba.y.write_addition_hint), Integer.valueOf(this.bTH.getAlreadyCount()), Integer.valueOf(this.bTH.getTotalCount())));
            this.avZ.setText(com.baidu.tieba.y.write_addition_title);
            return;
        }
        this.bTI.setVisibility(8);
    }

    private void acg() {
        this.bJA = findViewById(com.baidu.tieba.v.post_prefix_layout);
        this.bJx = (TextView) findViewById(com.baidu.tieba.v.post_prefix);
        this.bJz = (ImageView) findViewById(com.baidu.tieba.v.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.bJA.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.bJx.setText(prefixs.get(0));
            this.bJd = 0;
            this.bJA.setOnClickListener(new am(this));
            this.bJz = (ImageView) findViewById(com.baidu.tieba.v.prefix_icon);
            if (size > 1) {
                this.bJz.setVisibility(0);
                this.bJx.setOnClickListener(new ao(this));
            }
            this.bJy = new ch(this);
            this.bJy.a(this);
            this.bJy.setMaxHeight(com.baidu.adp.lib.util.m.dip2px(this, 225.0f));
            this.bJy.setOutsideTouchable(true);
            this.bJy.setFocusable(true);
            this.bJy.setOnDismissListener(this);
            this.bJy.setBackgroundDrawable(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.s.cp_bg_line_b));
            int color = com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.write_text);
            com.baidu.tbadk.core.util.aw.h((View) this.bJx, com.baidu.tieba.u.write_prefix_item_selector);
            com.baidu.tbadk.core.util.aw.c(this.bJz, com.baidu.tieba.u.icon_title_down);
            this.bJx.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.m.dip2px(this, 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                com.baidu.tbadk.core.util.aw.h((View) textView, com.baidu.tieba.u.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.m.dip2px(this, getResources().getDimension(com.baidu.tieba.t.ds6)), 0, com.baidu.adp.lib.util.m.dip2px(this, getResources().getDimension(com.baidu.tieba.t.ds22)), 0);
                this.bJy.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.m.dip2px(this, 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.m.dip2px(this, getResources().getDimension(com.baidu.tieba.t.ds6)), 0, com.baidu.adp.lib.util.m.dip2px(this, getResources().getDimension(com.baidu.tieba.t.ds22)), 0);
                }
            }
            this.bJy.dP(0);
            return;
        }
        this.bJA.setVisibility(8);
    }

    private void afv() {
        if (this.bTu && this.bpv != null) {
            this.bTx.setVisibility(0);
            this.bTw = new o(this);
            this.bTw.hJ(this.bpv.getForumName());
            this.bTw.setLoadDataCallBack(new ap(this));
        }
    }

    public void EB() {
        if (this.ayG == null) {
            String[] strArr = {getString(com.baidu.tieba.y.take_photo), getString(com.baidu.tieba.y.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(com.baidu.tieba.y.operation));
            builder.setItems(strArr, new aq(this));
            this.ayG = builder.create();
            this.ayG.setCanceledOnTouchOutside(true);
        }
    }

    protected void afw() {
        this.bJw.setOnClickListener(new ar(this));
    }

    protected void afx() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(com.baidu.tieba.y.is_save_draft)).setCancelable(false).setPositiveButton(getString(com.baidu.tieba.y.save), new as(this)).setNeutralButton(getString(com.baidu.tieba.y.not_save), new au(this));
        this.bTA = builder.create();
    }

    protected void ach() {
        this.bJr = (EditText) findViewById(com.baidu.tieba.v.post_title);
        this.bJr.setOnClickListener(this.bTU);
        this.bJr.setOnFocusChangeListener(this.bJp);
        if (this.bpv.getType() == 0) {
            if (this.bpv.getTitle() != null) {
                this.bJr.setText(this.bpv.getTitle());
                this.bJr.setSelection(this.bpv.getTitle().length());
            }
        } else if (this.bpv.getType() != 1) {
            this.bpv.getType();
        }
        this.bJr.addTextChangedListener(new av(this));
    }

    protected void acj() {
        this.bJv = (EditText) findViewById(com.baidu.tieba.v.post_content);
        this.bJv.setDrawingCacheEnabled(false);
        this.bJv.setOnClickListener(this.bTU);
        if (this.bpv.getContent() != null && this.bpv.getContent().length() > 0) {
            SpannableString q = TbFaceManager.sf().q(this, this.bpv.getContent());
            this.bJv.setText(q);
            this.bJv.setSelection(q.length());
        } else if (this.bpv.getType() == 2) {
            if (this.bTB) {
                if (this.bTC != null && this.bTC.length() > 0) {
                    this.bJv.setText(getString(com.baidu.tieba.y.reply_sub_floor, new Object[]{this.bTC}));
                    this.bJv.setSelection(this.bJv.getText().length());
                }
            } else if (this.bpv.getFloorNum() > 0) {
                String format = String.format(getString(com.baidu.tieba.y.reply_x_floor), Integer.valueOf(this.bpv.getFloorNum()));
                this.bJv.setText(format);
                this.bJv.setSelection(format.length());
            }
        }
        this.bJv.setOnFocusChangeListener(this.bJp);
        this.bJv.setOnTouchListener(new aw(this));
        this.bJv.addTextChangedListener(new ax(this));
        eM(true);
    }

    public void eM(boolean z) {
        this.bJv.setPadding(0, 0, 0, 0);
        this.bJv.setBackgroundDrawable(null);
        com.baidu.tbadk.core.util.aw.i((View) this.bJv, com.baidu.tieba.s.write_content_bg);
        if (!TextUtils.isEmpty(this.apZ) && this.bTH == null) {
            com.baidu.adp.lib.f.d.ef().a(this.apZ, 19, new ay(this, z), getUniqueId());
        }
    }

    public boolean Ch() {
        int i = 5000;
        if (this.bTH != null) {
            i = 1000;
        }
        return this.bJv.getText() != null && this.bJv.getText().length() >= i;
    }

    protected void afy() {
        this.are = (EditorToolComponetContainer) findViewById(com.baidu.tieba.v.tool_group);
        this.are.setFrom(1);
        this.are.rO();
        this.are.setOnActionListener(new ba(this));
    }

    protected void afz() {
        this.bTF.Bg();
        if (this.are.BB()) {
            this.are.BC();
        }
    }

    public void afA() {
        this.are.x(this.bJv);
    }

    public void hG(int i) {
        if (this.are.BB()) {
            hH(i);
            return;
        }
        this.are.w(this.bJr);
        this.are.w(this.bJv);
        new Handler().postDelayed(new bb(this, i), 200L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
        if (this.are != null) {
            this.are.BE();
        }
    }

    public void hH(int i) {
        if (i == 2) {
            this.bTF.Cz();
            this.are.BG();
        } else if (i == 5) {
            this.are.BH();
        } else if (i == 8) {
            this.are.BI();
        } else if (i == 50) {
            this.are.BK();
            this.bTF.CC();
        } else if (i == 44) {
            this.are.BJ();
            this.bTF.CA();
        } else if (i == 38) {
            this.are.BF();
            this.bTF.CD();
        }
    }

    protected void afB() {
        this.bTF = (TbEditorToolButtonContainer) findViewById(com.baidu.tieba.v.write_eidtor_tool_buttons);
        this.bTF.Bf();
        this.bTF.bB(this.bTH == null);
        this.bTF.setAtFocusable(false);
        this.bTF.setOnActionListener(new bc(this));
        this.bTF.refresh();
    }

    public void hI(int i) {
        BaobaoSdkDelegate baobaoSdkDelegate;
        if (PluginHelper.isBaoBaoCanUse(this)) {
            if (this.are.BM()) {
                hG(i);
            } else if (!com.baidu.tieba.e.a.adF() && this.bTM == 0) {
                showToast(com.baidu.tieba.y.baobao_over_limit);
            } else {
                String charSequence = this.avZ.getText().toString();
                Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_BAOBAO);
                if (pluginByName != null && (baobaoSdkDelegate = (BaobaoSdkDelegate) pluginByName.getClassInstance(BaobaoSdkDelegate.class)) != null) {
                    baobaoSdkDelegate.startMatchImage(this, charSequence, 12013);
                }
            }
        }
    }

    public void b(com.baidu.tbadk.coreExtra.data.d dVar) {
        if (((ImageSpan[]) this.bJv.getText().getSpans(0, this.bJv.getText().length(), ImageSpan.class)).length >= 10) {
            if (this.bTD == null) {
                this.bTD = Toast.makeText(this, com.baidu.tieba.y.too_many_face, 0);
            }
            this.bTD.show();
            return;
        }
        String name = dVar.getName();
        EmotionGroupType oy = dVar.oy();
        if (name != null) {
            com.baidu.adp.lib.f.d.ef().a(name, 20, new bd(this, new SpannableStringBuilder(name), this.bJv.getSelectionStart(), oy), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        Bitmap hl = aVar.hl();
        com.baidu.tieba.view.v vVar = new com.baidu.tieba.view.v(hl);
        vVar.setBounds(0, 0, hl.getWidth() + 1, hl.getHeight());
        vVar.setGravity(3);
        spannableStringBuilder.setSpan(new ImageSpan(vVar, 0), 0, spannableStringBuilder.length(), 33);
        this.bJv.getText().insert(i, spannableStringBuilder);
    }

    public void afC() {
        this.bJv.onKeyDown(67, this.bTy);
    }

    private void f(Boolean bool) {
        String str = null;
        if (this.bpv != null) {
            str = this.bpv.getForumName();
        }
        if (com.baidu.tieba.e.b.b(str, bool)) {
            this.are.Br();
        } else {
            this.are.Bq();
        }
    }

    private void afD() {
        getVoiceManager().onCreate(this);
    }

    private void afE() {
        try {
            if (this.bTA != null && this.bTA.isShowing()) {
                com.baidu.adp.lib.g.j.b(this.bTA, this);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    private Boolean afF() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.buF = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void aci() {
        String str = null;
        if (this.bpv.getType() == 0) {
            String trim = this.bJr.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.bJd == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.bpv.setIsNoTitle(true);
                    } else {
                        this.bpv.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.bpv.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.bpv.setIsNoTitle(true);
            } else {
                this.bpv.setIsNoTitle(false);
                str = "1";
            }
        }
        String trim2 = this.bJv.getText().toString().trim();
        if (this.are.BL()) {
            str = "1";
        } else if (!TextUtils.isEmpty(trim2)) {
            str = "1";
        } else if (this.are.BN()) {
            str = "1";
        } else if (this.are.BM()) {
            str = "1";
        }
        if (str == null || str.length() <= 0) {
            this.bJw.setEnabled(false);
        } else {
            this.bJw.setEnabled(true);
        }
    }

    private void d(Bundle bundle) {
        this.ayz = new com.baidu.tieba.model.ar(this);
        this.ayz.a(this.ayC);
        registerListener(this.bTR);
        this.ays = new com.baidu.tieba.location.d(this);
        this.ays.a(this.ayD);
        this.bCh = new be(this);
        this.bpv = new WriteData();
        if (bundle != null) {
            this.bpv.setType(bundle.getInt("type", 0));
            this.bpv.setForumId(bundle.getString("forum_id"));
            this.bpv.setForumName(bundle.getString("forum_name"));
            this.bpv.setThreadId(bundle.getString("thread_id"));
            this.bpv.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.bpv.setFloorNum(bundle.getInt(WriteActivityConfig.FLOOR_NUM, 0));
            this.bTu = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.bTB = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.bTC = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.baobaoImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.BAOBAO_IMAGES);
            this.ayx = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.bTH = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.bpv.setIsAddition(this.bTH != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.bTM = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            if (bundle.getBoolean(WriteActivityConfig.IS_LIVE_POST)) {
                LiveCardData liveCardData = new LiveCardData();
                liveCardData.setStartTime(bundle.getLong(WriteActivityConfig.LIVE_DATE));
                liveCardData.setAuthorName(bundle.getString(WriteActivityConfig.LIVE_GROUP_PUBLISH_NAME));
                liveCardData.setPortrait(bundle.getString(WriteActivityConfig.LIVE_GROUP_HEAD));
                liveCardData.setIntro(bundle.getString(WriteActivityConfig.LIVE_GROUP_INTRO));
                liveCardData.setListeners(bundle.getInt(WriteActivityConfig.LIVE_GROUP_MEMBER_COUNT, 0));
                liveCardData.setName(bundle.getString(WriteActivityConfig.LIVE_GROUP_NAME));
                liveCardData.setLikers(bundle.getInt(WriteActivityConfig.LIVE_GROUP_ZAN_COUNT, 0));
                liveCardData.setGroupId(bundle.getInt(WriteActivityConfig.LIVE_GROUP_ID, 0));
                liveCardData.setModifyTime(bundle.getBoolean(WriteActivityConfig.LIVE_TIME_IS_MODIFY));
                liveCardData.setPublisherPortrait(bundle.getString(WriteActivityConfig.LIVE_GROUP_PUBLISH_HEAD));
                this.bpv.setLiveCardData(liveCardData);
            }
        } else {
            Intent intent = getIntent();
            this.bpv.setType(intent.getIntExtra("type", 0));
            this.bpv.setForumId(intent.getStringExtra("forum_id"));
            this.bpv.setForumName(intent.getStringExtra("forum_name"));
            this.bpv.setThreadId(intent.getStringExtra("thread_id"));
            this.bpv.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.bpv.setFloorNum(intent.getIntExtra(WriteActivityConfig.FLOOR_NUM, 0));
            this.bTu = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.bTB = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.bTC = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.bTH = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.bpv.setIsAddition(this.bTH != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.bTM = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            if (intent.getBooleanExtra(WriteActivityConfig.IS_LIVE_POST, false)) {
                LiveCardData liveCardData2 = new LiveCardData();
                liveCardData2.setStartTime(new Date().getTime() / 1000);
                liveCardData2.setAuthorName(intent.getStringExtra(WriteActivityConfig.LIVE_GROUP_PUBLISH_NAME));
                liveCardData2.setPortrait(intent.getStringExtra(WriteActivityConfig.LIVE_GROUP_HEAD));
                liveCardData2.setIntro(intent.getStringExtra(WriteActivityConfig.LIVE_GROUP_INTRO));
                liveCardData2.setListeners(intent.getIntExtra(WriteActivityConfig.LIVE_GROUP_MEMBER_COUNT, 0));
                liveCardData2.setName(intent.getStringExtra(WriteActivityConfig.LIVE_GROUP_NAME));
                liveCardData2.setLikers(intent.getIntExtra(WriteActivityConfig.LIVE_GROUP_ZAN_COUNT, 0));
                liveCardData2.setGroupId(intent.getIntExtra(WriteActivityConfig.LIVE_GROUP_ID, 0));
                liveCardData2.setPublisherPortrait(intent.getStringExtra(WriteActivityConfig.LIVE_GROUP_PUBLISH_HEAD));
                this.bpv.setLiveCardData(liveCardData2);
            }
        }
        this.baobaoImagesInfo.setMaxImagesAllowed(1);
        this.writeImagesInfo.setMaxImagesAllowed(10);
        this.bpv.setWriteImagesInfo(this.writeImagesInfo);
        this.bpv.setBaobaoImagesInfo(this.baobaoImagesInfo);
        if (this.bpv.getType() == 0) {
            if (this.bpv.getLiveCardData() == null) {
                com.baidu.tieba.util.l.b(this.bpv.getForumId(), this);
            } else {
                com.baidu.tieba.util.l.a(this.bpv.getLiveCardData().getGroupId(), this);
            }
        } else if (this.bpv.getType() == 1) {
            com.baidu.tieba.util.l.a(this.bpv.getThreadId(), this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getString(com.baidu.tieba.y.write_no_prefix));
        }
        this.apZ = TbadkApplication.m251getInst().getDefaultBubble();
        if (this.bpv != null && this.bpv.getForumName() != null && com.baidu.tieba.aj.wk().wW() != null && this.bpv.getForumName().equals(com.baidu.tieba.aj.wk().wW())) {
            this.bTv = true;
        }
    }

    @Override // com.baidu.tieba.util.m
    public void a(WriteData writeData) {
        if (writeData != null && this.bpv != null) {
            this.bpv.setHaveDraft(true);
            if (com.baidu.adp.lib.util.l.aA(this.bJr.getText().toString()) || ((this.bTu || this.bTv) && !com.baidu.adp.lib.util.l.aA(writeData.getTitle()))) {
                this.bpv.setTitle(writeData.getTitle());
                this.bJr.setText(this.bpv.getTitle());
                this.bJr.setSelection(this.bpv.getTitle().length());
            }
            if (writeData.getLiveCardData() != null) {
                Date date = new Date(writeData.getLiveCardData().getStartTime() * 1000);
                Date date2 = new Date();
                date.setYear(date2.getYear());
                date.setMonth(date2.getMonth());
                date.setDate(date2.getDate());
                this.bpv.getLiveCardData().setStartTime(date.getTime() / 1000);
                this.bTO.setText(com.baidu.tbadk.core.util.ay.k(this.bpv.getLiveCardData().getStartTime() * 1000));
            }
            if ((com.baidu.adp.lib.util.l.aA(this.bJv.getText().toString()) || this.bTu || this.bTv) && !com.baidu.adp.lib.util.l.aA(writeData.getContent())) {
                this.bpv.setContent(writeData.getContent());
                SpannableString a = TbFaceManager.sf().a(this, this.bpv.getContent(), new bf(this));
                this.bJv.setText(a);
                this.bJv.setSelection(a.length());
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo = writeData.getWriteImagesInfo();
                this.bpv.setWriteImagesInfo(this.writeImagesInfo);
                this.are.a(this.writeImagesInfo, true);
                eN(false);
            }
            if (TbadkApplication.m251getInst().isBaobaoShouldOpen()) {
                if (writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                    this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                    this.bpv.setIsBaobao(writeData.getIsBaobao());
                    this.bpv.setBaobaoContent(writeData.getBaobaoContent());
                    this.bpv.setBaobaoImagesInfo(this.baobaoImagesInfo);
                }
                if (this.bpv.getIsBaobao()) {
                    this.are.setBaobaoUris(this.baobaoImagesInfo);
                    eO(false);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.bpv.getType());
        bundle.putString("forum_id", this.bpv.getForumId());
        bundle.putString("forum_name", this.bpv.getForumName());
        bundle.putString("thread_id", this.bpv.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.bpv.getFloor());
        bundle.putInt(WriteActivityConfig.FLOOR_NUM, this.bpv.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.bTB);
        if (this.bTu) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putSerializable(WriteActivityConfig.BAOBAO_IMAGES, this.baobaoImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.ayx);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.bTH);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.bTM);
        if (this.bpv.getLiveCardData() != null) {
            bundle.putBoolean(WriteActivityConfig.IS_LIVE_POST, true);
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ID, this.bpv.getLiveCardData().getGroupId());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_HEAD, this.bpv.getLiveCardData().getPortrait());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_INTRO, this.bpv.getLiveCardData().getIntro());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_NAME, this.bpv.getLiveCardData().getName());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_MEMBER_COUNT, this.bpv.getLiveCardData().getListeners());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ZAN_COUNT, this.bpv.getLiveCardData().getLikers());
            bundle.putLong(WriteActivityConfig.LIVE_DATE, this.bpv.getLiveCardData().getStartTime());
            bundle.putBoolean(WriteActivityConfig.LIVE_TIME_IS_MODIFY, this.bpv.getLiveCardData().isModifyTime());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_PUBLISH_HEAD, this.bpv.getLiveCardData().getPublisherPortrait());
        }
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(this);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = this.bJv.getEditableText().toString();
        if (editable != null) {
            this.bJv.setText(TbFaceManager.sf().q(this, editable));
            this.bJv.setSelection(this.bJv.getText().length());
        }
    }

    public void acd() {
        aca();
        if (this.bpv.getLiveCardData() != null) {
            if (!this.bpv.getLiveCardData().isModifyTime()) {
                this.bpv.getLiveCardData().setStartTime(new Date().getTime() / 1000);
                this.bTO.setText(com.baidu.tbadk.core.util.ay.k(this.bpv.getLiveCardData().getStartTime() * 1000));
            }
            long time = new Date().getTime() / TbConfig.USE_TIME_INTERVAL;
            Date date = new Date(this.bpv.getLiveCardData().getStartTime() * 1000);
            Date date2 = new Date();
            date.setYear(date2.getYear());
            date.setMonth(date2.getMonth());
            date.setDate(date2.getDate());
            this.bpv.getLiveCardData().setStartTime(date.getTime() / 1000);
            if (time > this.bpv.getLiveCardData().getStartTime() / 60) {
                showToast(com.baidu.tieba.y.live_start_time_error);
                return;
            }
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.bJd != this.mPrefixData.getPrefixs().size() - 1) {
            this.bpv.setTitle(String.valueOf(this.bJx.getText().toString()) + this.bJr.getText().toString());
        } else {
            this.bpv.setTitle(this.bJr.getText().toString());
        }
        this.bpv.setContent(this.bJv.getText().toString());
        if (this.bTu || this.bTv) {
            String string = getResources().getString(com.baidu.tieba.y.android_feedback);
            if (TextUtils.isEmpty(this.bpv.getTitle()) || !this.bpv.getTitle().startsWith(string)) {
                this.bpv.setTitle(string + this.bpv.getTitle());
            }
            String string2 = getResources().getString(com.baidu.tieba.y.tieba_client);
            if (TextUtils.isEmpty(this.bpv.getContent()) || !this.bpv.getContent().startsWith(string2)) {
                StringBuilder sb = new StringBuilder();
                sb.append(string2);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.j.fh()) {
                    sb.append(com.baidu.adp.lib.util.j.fo());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.bpv.getContent());
                this.bpv.setContent(sb.toString());
            }
        }
        this.bpv.setWriteImagesInfo(this.writeImagesInfo);
        this.bpv.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.bpv.setHasLocationData(this.bTE.getLocationInfoViewState() == 2);
        this.ayz.dI(this.writeImagesInfo.size() > 0);
        this.ayz.b(this.bpv);
        VoiceData.VoiceModel audioData = this.are.getAudioData();
        this.are.BQ();
        this.bpv.setVcode(null);
        if (audioData != null) {
            if (audioData.getId() != null) {
                this.ayz.EC().setVoice(audioData.getId());
                this.ayz.EC().setVoiceDuringTime(audioData.duration);
            } else {
                this.ayz.EC().setVoice(null);
                this.ayz.EC().setVoiceDuringTime(-1);
            }
        } else {
            this.ayz.EC().setVoice(null);
            this.ayz.EC().setVoiceDuringTime(-1);
        }
        if (!this.ayz.TS()) {
            showToast(com.baidu.tieba.y.write_img_limit);
        } else if (this.ayz.TR()) {
            showLoadingDialog(getString(com.baidu.tieba.y.sending), this.bCh);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        int size;
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12004) {
                ArrayList<String> p = com.baidu.tieba.util.i.p(intent);
                if (p != null && p.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < p.size()) {
                            sb.append("@");
                            sb.append(p.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            this.bJv.getText().insert(this.bJv.getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                if (this.bpv.getType() == 0) {
                    com.baidu.tieba.util.l.a(this.bpv.getForumId(), (WriteData) null);
                } else if (this.bpv.getType() == 1) {
                    com.baidu.tieba.util.l.b(this.bpv.getThreadId(), (WriteData) null);
                }
                setResult(-1);
                finish();
            } else if (i == 12002) {
                e(intent);
                aci();
                this.are.setVisibility(0);
            } else if (i == 12001) {
                g(intent);
                int size2 = this.writeImagesInfo.size() - 1;
                if (size2 > -1 && this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this, 12012, this.writeImagesInfo, size2)));
                }
            } else if (i == 12012) {
                f(intent);
                aci();
            } else if (i == 12013) {
                h(intent);
                aci();
            } else if (i == 23004) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    ED();
                    return;
                case 12002:
                    if (!this.are.BL()) {
                        afz();
                    }
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                        return;
                    }
                    return;
                case 12009:
                    ck.m(this);
                    return;
                case 12010:
                    this.ayx = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.av.a(this, this.ayx);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.bJr);
        HidenSoftKeyPad(this.mInputManager, this.bJv);
        super.onPause();
        getVoiceManager().onPause(this);
    }

    private void e(Intent intent) {
        b(intent, true);
    }

    private void g(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.ayx;
        if (!TextUtils.isEmpty(str)) {
            try {
                int bl = com.baidu.tbadk.core.util.d.bl(str);
                if (bl != 0) {
                    Bitmap a = com.baidu.tbadk.core.util.d.a(str, com.baidu.adp.lib.util.m.dip2px(this, com.baidu.adp.lib.util.m.n(this)), com.baidu.adp.lib.util.m.dip2px(this, com.baidu.adp.lib.util.m.o(this)));
                    Bitmap e = com.baidu.tbadk.core.util.d.e(a, bl);
                    if (a != e) {
                        a.recycle();
                    }
                    com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.ayx, e, 100);
                    e.recycle();
                }
            } catch (Exception e2) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            this.are.a(this.writeImagesInfo, true);
        }
        eN(true);
    }

    private void f(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    this.are.a(this.writeImagesInfo, z);
                }
            }
            eN(true);
        }
    }

    private void h(Intent intent) {
        if (this.bpv != null) {
            String stringExtra = intent.getStringExtra(BaobaoSdkDelegate.KEY_BITMAPPATH);
            String stringExtra2 = intent.getStringExtra(BaobaoSdkDelegate.KEY_CONTENT);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(stringExtra);
            this.baobaoImagesInfo.clear();
            this.baobaoImagesInfo.addChooseFile(imageFileInfo);
            this.bpv.setIsBaobao(true);
            this.bpv.setBaobaoContent(stringExtra2);
            this.are.setBaobaoUris(this.baobaoImagesInfo);
            eO(true);
        }
    }

    private void ED() {
        new bg(this).execute(new Void[0]);
    }

    private void eN(boolean z) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() > 0) {
            this.bTF.di(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            this.bTG = true;
            this.are.di(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            if (this.are.BB() || z) {
                this.are.BI();
                return;
            }
            return;
        }
        this.bTF.rD();
        this.bTG = false;
        this.are.rD();
        if (this.are.BN()) {
            this.bTF.Cl();
            this.are.rL();
        }
        afz();
    }

    private void eO(boolean z) {
        LinkedList<ImageFileInfo> chosedFiles = this.baobaoImagesInfo.getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() > 0) {
            this.bTF.CC();
            this.bTF.dk("1");
            if (this.are.BB() || z) {
                this.are.BK();
            }
            this.bpv.setIsBaobao(true);
            return;
        }
        this.bTF.rK();
        this.bpv.setIsBaobao(false);
        this.bTF.CB();
        afz();
    }

    @Override // com.baidu.tbadk.core.voice.o
    public synchronized VoiceManager getVoiceManager() {
        if (this.ayo == null) {
            this.ayo = VoiceManager.instance();
        }
        return this.ayo;
    }

    @Override // com.baidu.tbadk.core.voice.o
    public com.baidu.tbadk.core.voice.m b(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public synchronized void EA() {
        this.ayo = getVoiceManager();
        this.ayo.stopPlay();
    }

    public void b(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.bpv.getForumName());
            AntiHelper.a(this, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.WRITE);
            return;
        }
        ck.J(this, str);
    }

    @Override // com.baidu.tieba.write.ci
    public void hj(int i) {
        this.bJd = i;
        this.bJy.dP(i);
        this.bJx.setText(this.mPrefixData.getPrefixs().get(i));
        aci();
        com.baidu.adp.lib.g.j.a(this.bJy, this);
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.bJA.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.GW.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
