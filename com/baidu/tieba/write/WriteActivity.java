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
    private GestureDetector GX;
    private com.baidu.tieba.location.d ayB;
    private String ayG;
    private com.baidu.tieba.model.ar ayI;
    private VoiceManager ayx;
    private View bJI;
    private TextView bJM;
    private ch bJN;
    private ImageView bJO;
    private View bJP;
    private int bJr;
    private Toast bTS;
    private AdditionData bTW;
    private RelativeLayout bTX;
    private TextView bTY;
    private TextView bTZ;
    private TextView bUa;
    private RelativeLayout bUc;
    private TextView bUd;
    private View bUe;
    private LiveBroadcastCard bUf;
    private com.baidu.tieba.view.c bUl;
    private PostPrefixData mPrefixData;
    private WriteData bpJ = null;
    private boolean bTJ = false;
    private boolean bTK = false;
    private InputMethodManager mInputManager = null;
    private EditText bJG = null;
    private View bJH = null;
    private LinearLayout bJJ = null;
    private EditText bJK = null;
    private AlertDialog ayP = null;
    private o bTL = null;
    private FeedBackTopListView bTM = null;
    private String aqi = null;
    private final KeyEvent bTN = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View Jt = null;
    private TextView bTO = null;
    private TextView bJL = null;
    private TextView awi = null;
    private DialogInterface.OnCancelListener bCv = null;
    private AlertDialog bTP = null;
    private final Handler mHandler = new Handler();
    private boolean bTQ = false;
    private String bTR = null;
    private RelativeLayout mParent = null;
    private String buT = null;
    private com.baidu.tieba.editortool.j bTT = null;
    private TbEditorToolButtonContainer bTU = null;
    private EditorToolComponetContainer arn = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private boolean bTV = false;
    private int bUb = 0;
    private HttpMessageListener bUg = new ac(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private final com.baidu.tieba.model.as ayL = new an(this);
    private com.baidu.tieba.location.i ayM = new az(this);
    private View.OnClickListener bUh = new bh(this);
    private CustomMessageListener bmi = new bi(this, 2001232);
    private final Runnable bUi = new bj(this);
    private final View.OnClickListener bUj = new bk(this);
    private boolean bUk = true;
    private final View.OnFocusChangeListener bJE = new bl(this);
    private com.baidu.tieba.bubble.t aDB = new bm(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(WriteActivityConfig.class, WriteActivity.class);
        com.baidu.tieba.location.d.Sx();
    }

    public void Ey() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this)));
    }

    public void Ez() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this)) {
            showToast(com.baidu.tieba.y.location_system_permission_prompt);
            this.bTT.setLocationInfoViewState(0);
        } else if (!TbadkApplication.m251getInst().getLocationShared()) {
            EA();
        } else if (this.ayB.Sw()) {
            Ey();
        } else {
            this.ayB.dx(false);
            this.bTT.setLocationInfoViewState(1);
            this.ayB.Su();
        }
    }

    private void EA() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.aX(com.baidu.tieba.y.location_app_permission_prompt).a(com.baidu.tieba.y.isopen, new ad(this)).b(com.baidu.tieba.y.cancel, new ae(this)).kT();
        aVar.kW();
    }

    public int aft() {
        int selectionEnd = this.bJK.getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) this.bJK.getText().getSpans(0, this.bJK.getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = this.bJK.getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = this.bJK.getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    public void afu() {
        if (!this.bUk) {
            this.bTU.Bg();
        } else {
            this.bTU.Bh();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(this);
        this.arn.BV();
        if (this.bUl != null && this.bpJ != null && this.bpJ.getLiveCardData() != null) {
            new Handler().postDelayed(new af(this, new Date(this.bpJ.getLiveCardData().getStartTime() * 1000)), 100L);
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
        this.arn.BT();
        getVoiceManager().onStop(this);
        getWindow().setSoftInputMode(18);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BdLog.addLogPackage(WriteActivity.class.getPackage().getName());
        super.onCreate(bundle);
        registerListener(this.bmi);
        this.GX = new GestureDetector(this, new bn(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        d(bundle);
        initUI();
        afy();
        if (this.bTW == null) {
            EB();
        }
    }

    private void EB() {
        if (this.ayB.Sy()) {
            if (this.ayB.Sw()) {
                this.bTT.j(2, com.baidu.tieba.location.c.Sr().getLocationData().So());
                return;
            }
            this.bTT.setLocationInfoViewState(1);
            this.ayB.Su();
            return;
        }
        this.bTT.setLocationInfoViewState(0);
    }

    public void acd() {
        if (this.ayI != null) {
            this.ayI.cancelLoadData();
        }
        if (this.bTL != null) {
            this.bTL.cancelLoadData();
        }
        if (this.ayB != null) {
            this.ayB.cancelLoadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        acd();
        afH();
        super.onDestroy();
        getVoiceManager().onDestory(this);
    }

    public void afv() {
        if (this.bpJ != null && this.bpJ.getType() == 2 && this.bTQ) {
            finish();
        } else if (this.bpJ == null) {
            finish();
        } else {
            this.bpJ.setTitle(this.bJG.getText().toString());
            this.bpJ.setContent(this.bJK.getText().toString());
            int type = this.bpJ.getType();
            if (this.bpJ.getHaveDraft() && com.baidu.adp.lib.util.l.aA(this.bpJ.getTitle()) && com.baidu.adp.lib.util.l.aA(this.bpJ.getContent()) && !this.bpJ.isHasImages()) {
                if (type == 0) {
                    if (this.bpJ.getLiveCardData() == null) {
                        com.baidu.tieba.util.l.a(this.bpJ.getForumId(), (WriteData) null);
                    } else {
                        com.baidu.tieba.util.l.a(this.bpJ.getLiveCardData().getGroupId(), (WriteData) null);
                    }
                } else if (type == 1) {
                    com.baidu.tieba.util.l.b(this.bpJ.getThreadId(), (WriteData) null);
                }
            } else if (type == 0) {
                if (this.bpJ.getLiveCardData() == null) {
                    com.baidu.tieba.util.l.a(this.bpJ.getForumId(), this.bpJ);
                } else {
                    com.baidu.tieba.util.l.a(this.bpJ.getLiveCardData().getGroupId(), this.bpJ);
                }
            } else if (type == 1) {
                com.baidu.tieba.util.l.b(this.bpJ.getThreadId(), this.bpJ);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bJN != null && this.bJN.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.bJN, this);
                return true;
            } else if (this.arn.BD()) {
                this.bTU.Bi();
                this.arn.BE();
                return true;
            } else {
                acd();
                afv();
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
        com.baidu.tbadk.core.util.aw.f(this.bJL, i);
        afu();
        com.baidu.tbadk.core.util.aw.i(this.bJH, com.baidu.tieba.s.write_line1);
        com.baidu.tbadk.core.util.aw.i(this.bJI, com.baidu.tieba.s.write_line1);
        com.baidu.tbadk.core.util.aw.i((View) this.bJG, com.baidu.tieba.s.write_title_bg);
        if (TextUtils.isEmpty(this.aqi)) {
            com.baidu.tbadk.core.util.aw.i((View) this.bJK, com.baidu.tieba.s.write_content_bg);
        }
        int color = com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.cp_cont_e);
        this.bTU.changeSkinType(i);
        this.bJG.setTextColor(color);
        this.bJK.setTextColor(color);
        a(this.bJG, color2);
        a(this.bJK, color2);
        acl();
        this.arn.onChangeSkinType(i);
        this.bTT.sD();
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
        this.Jt = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.awi = this.mNavigationBar.setTitleText("");
        this.bTO = (TextView) findViewById(com.baidu.tieba.v.btn_image_problem);
        this.bJL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.y.send));
        this.bJL.setOnFocusChangeListener(this.bJE);
        addGlobalLayoutListener();
        this.bTM = (FeedBackTopListView) findViewById(com.baidu.tieba.v.feedback_top_list);
        this.mParent = (RelativeLayout) findViewById(com.baidu.tieba.v.parent);
        this.bJH = findViewById(com.baidu.tieba.v.interval_view);
        this.bJI = findViewById(com.baidu.tieba.v.prefix_interval_view);
        ack();
        this.mHandler.postDelayed(this.bUi, 200L);
        acm();
        if (this.bTJ || this.bTK) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.httpNet.a.mT().hasImageProblem()) {
                findViewById(com.baidu.tieba.v.ll_image_problem).setVisibility(0);
            } else {
                findViewById(com.baidu.tieba.v.ll_image_problem).setVisibility(8);
            }
        }
        this.bJJ = (LinearLayout) findViewById(com.baidu.tieba.v.post_content_container);
        this.bJJ.setDrawingCacheEnabled(false);
        this.bJJ.setOnClickListener(new ag(this));
        this.Jt.setOnFocusChangeListener(this.bJE);
        this.Jt.setOnClickListener(new ah(this));
        this.bTO.setOnClickListener(new ai(this));
        this.bTT = new com.baidu.tieba.editortool.j((EditorInfoContainer) findViewById(com.baidu.tieba.v.write_editor_info));
        this.bTT.g(this.bUh);
        if (this.bTW != null) {
            this.bTT.destroy();
        }
        afE();
        afB();
        afz();
        if (!TbadkApplication.m251getInst().isBaobaoShouldOpen() || this.bTW != null) {
            this.bTU.CH();
        }
        if (this.bpJ.getType() == 0) {
            if (this.bTJ || this.bTK) {
                this.bTU.CH();
                this.awi.setText(com.baidu.tieba.y.feedback);
            } else {
                this.awi.setText(com.baidu.tieba.y.post_new_thread);
            }
            this.bJG.setVisibility(0);
            this.bJK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
        } else {
            this.awi.setText(com.baidu.tieba.y.send_reply);
            this.bJK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
            this.bJG.setVisibility(8);
        }
        afA();
        afG();
        f(afI());
        afu();
        afx();
        acj();
        afw();
        acl();
        if (this.bpJ.getLiveCardData() == null) {
            ShowSoftKeyPad(this.mInputManager, this.bJG);
        }
    }

    private void afw() {
        this.bUc = (RelativeLayout) findViewById(com.baidu.tieba.v.live_time_rel);
        this.bUd = (TextView) findViewById(com.baidu.tieba.v.live_tiem_show);
        this.bUe = findViewById(com.baidu.tieba.v.interval_view2);
        this.bUf = (LiveBroadcastCard) findViewById(com.baidu.tieba.v.live_anchor_card);
        this.bUc.setOnClickListener(new aj(this));
        this.bUc.setOnTouchListener(new ak(this));
        if (this.bpJ.getLiveCardData() != null) {
            this.bUc.setVisibility(0);
            this.bUe.setVisibility(0);
            this.bUf.setVisibility(0);
            this.bUf.setClickable(false);
            this.bUd.setText(com.baidu.tbadk.core.util.az.k(this.bpJ.getLiveCardData().getStartTime() * 1000));
            this.bUf.setData(this.bpJ.getLiveCardData());
            return;
        }
        this.bUc.setVisibility(8);
        this.bUe.setVisibility(8);
        this.bUf.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if ((dialog instanceof com.baidu.tieba.view.c) && this.bpJ.getLiveCardData() != null) {
            Date date = new Date(this.bpJ.getLiveCardData().getStartTime() * 1000);
            ((com.baidu.tieba.view.c) dialog).updateTime(date.getHours(), date.getMinutes());
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.bUl = new com.baidu.tieba.view.c(this, new al(this), new Date().getHours(), new Date().getMinutes(), false);
        this.bUl.setTitle(com.baidu.tieba.y.no_disturb_start_time);
        this.bUl.setButton(-1, getString(com.baidu.tieba.y.alert_yes_button), this.bUl);
        this.bUl.setButton(-2, getString(com.baidu.tieba.y.alert_no_button), this.bUl);
        return this.bUl;
    }

    private void afx() {
        this.bTX = (RelativeLayout) findViewById(com.baidu.tieba.v.addition_container);
        this.bTY = (TextView) findViewById(com.baidu.tieba.v.addition_create_time);
        this.bTZ = (TextView) findViewById(com.baidu.tieba.v.addition_last_time);
        this.bUa = (TextView) findViewById(com.baidu.tieba.v.addition_last_content);
        if (this.bTW != null) {
            this.bTX.setVisibility(0);
            this.bTY.setText(String.valueOf(getString(com.baidu.tieba.y.write_addition_create)) + com.baidu.tbadk.core.util.az.j(this.bTW.getCreateTime() * 1000));
            if (this.bTW.getAlreadyCount() == 0) {
                this.bTZ.setVisibility(8);
            } else {
                this.bTZ.setText(String.valueOf(getString(com.baidu.tieba.y.write_addition_last)) + com.baidu.tbadk.core.util.az.j(this.bTW.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.bTW.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.bUa.setText(lastAdditionContent);
            } else {
                this.bUa.setVisibility(8);
            }
            this.bJK.setHint(String.format(getString(com.baidu.tieba.y.write_addition_hint), Integer.valueOf(this.bTW.getAlreadyCount()), Integer.valueOf(this.bTW.getTotalCount())));
            this.awi.setText(com.baidu.tieba.y.write_addition_title);
            return;
        }
        this.bTX.setVisibility(8);
    }

    private void acj() {
        this.bJP = findViewById(com.baidu.tieba.v.post_prefix_layout);
        this.bJM = (TextView) findViewById(com.baidu.tieba.v.post_prefix);
        this.bJO = (ImageView) findViewById(com.baidu.tieba.v.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.bJP.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.bJM.setText(prefixs.get(0));
            this.bJr = 0;
            this.bJP.setOnClickListener(new am(this));
            this.bJO = (ImageView) findViewById(com.baidu.tieba.v.prefix_icon);
            if (size > 1) {
                this.bJO.setVisibility(0);
                this.bJM.setOnClickListener(new ao(this));
            }
            this.bJN = new ch(this);
            this.bJN.a(this);
            this.bJN.setMaxHeight(com.baidu.adp.lib.util.m.dip2px(this, 225.0f));
            this.bJN.setOutsideTouchable(true);
            this.bJN.setFocusable(true);
            this.bJN.setOnDismissListener(this);
            this.bJN.setBackgroundDrawable(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.s.cp_bg_line_b));
            int color = com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.write_text);
            com.baidu.tbadk.core.util.aw.h((View) this.bJM, com.baidu.tieba.u.write_prefix_item_selector);
            com.baidu.tbadk.core.util.aw.c(this.bJO, com.baidu.tieba.u.icon_title_down);
            this.bJM.setTextColor(color);
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
                this.bJN.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.m.dip2px(this, 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.m.dip2px(this, getResources().getDimension(com.baidu.tieba.t.ds6)), 0, com.baidu.adp.lib.util.m.dip2px(this, getResources().getDimension(com.baidu.tieba.t.ds22)), 0);
                }
            }
            this.bJN.dP(0);
            return;
        }
        this.bJP.setVisibility(8);
    }

    private void afy() {
        if (this.bTJ && this.bpJ != null) {
            this.bTM.setVisibility(0);
            this.bTL = new o(this);
            this.bTL.hJ(this.bpJ.getForumName());
            this.bTL.setLoadDataCallBack(new ap(this));
        }
    }

    public void ED() {
        if (this.ayP == null) {
            String[] strArr = {getString(com.baidu.tieba.y.take_photo), getString(com.baidu.tieba.y.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(com.baidu.tieba.y.operation));
            builder.setItems(strArr, new aq(this));
            this.ayP = builder.create();
            this.ayP.setCanceledOnTouchOutside(true);
        }
    }

    protected void afz() {
        this.bJL.setOnClickListener(new ar(this));
    }

    protected void afA() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(com.baidu.tieba.y.is_save_draft)).setCancelable(false).setPositiveButton(getString(com.baidu.tieba.y.save), new as(this)).setNeutralButton(getString(com.baidu.tieba.y.not_save), new au(this));
        this.bTP = builder.create();
    }

    protected void ack() {
        this.bJG = (EditText) findViewById(com.baidu.tieba.v.post_title);
        this.bJG.setOnClickListener(this.bUj);
        this.bJG.setOnFocusChangeListener(this.bJE);
        if (this.bpJ.getType() == 0) {
            if (this.bpJ.getTitle() != null) {
                this.bJG.setText(this.bpJ.getTitle());
                this.bJG.setSelection(this.bpJ.getTitle().length());
            }
        } else if (this.bpJ.getType() != 1) {
            this.bpJ.getType();
        }
        this.bJG.addTextChangedListener(new av(this));
    }

    protected void acm() {
        this.bJK = (EditText) findViewById(com.baidu.tieba.v.post_content);
        this.bJK.setDrawingCacheEnabled(false);
        this.bJK.setOnClickListener(this.bUj);
        if (this.bpJ.getContent() != null && this.bpJ.getContent().length() > 0) {
            SpannableString q = TbFaceManager.sh().q(this, this.bpJ.getContent());
            this.bJK.setText(q);
            this.bJK.setSelection(q.length());
        } else if (this.bpJ.getType() == 2) {
            if (this.bTQ) {
                if (this.bTR != null && this.bTR.length() > 0) {
                    this.bJK.setText(getString(com.baidu.tieba.y.reply_sub_floor, new Object[]{this.bTR}));
                    this.bJK.setSelection(this.bJK.getText().length());
                }
            } else if (this.bpJ.getFloorNum() > 0) {
                String format = String.format(getString(com.baidu.tieba.y.reply_x_floor), Integer.valueOf(this.bpJ.getFloorNum()));
                this.bJK.setText(format);
                this.bJK.setSelection(format.length());
            }
        }
        this.bJK.setOnFocusChangeListener(this.bJE);
        this.bJK.setOnTouchListener(new aw(this));
        this.bJK.addTextChangedListener(new ax(this));
        eM(true);
    }

    public void eM(boolean z) {
        this.bJK.setPadding(0, 0, 0, 0);
        this.bJK.setBackgroundDrawable(null);
        com.baidu.tbadk.core.util.aw.i((View) this.bJK, com.baidu.tieba.s.write_content_bg);
        if (!TextUtils.isEmpty(this.aqi) && this.bTW == null) {
            com.baidu.adp.lib.f.d.ef().a(this.aqi, 19, new ay(this, z), getUniqueId());
        }
    }

    public boolean Cj() {
        int i = 5000;
        if (this.bTW != null) {
            i = 1000;
        }
        return this.bJK.getText() != null && this.bJK.getText().length() >= i;
    }

    protected void afB() {
        this.arn = (EditorToolComponetContainer) findViewById(com.baidu.tieba.v.tool_group);
        this.arn.setFrom(1);
        this.arn.rQ();
        this.arn.setOnActionListener(new ba(this));
    }

    protected void afC() {
        this.bTU.Bi();
        if (this.arn.BD()) {
            this.arn.BE();
        }
    }

    public void afD() {
        this.arn.x(this.bJK);
    }

    public void hG(int i) {
        if (this.arn.BD()) {
            hH(i);
            return;
        }
        this.arn.w(this.bJG);
        this.arn.w(this.bJK);
        new Handler().postDelayed(new bb(this, i), 200L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
        if (this.arn != null) {
            this.arn.BG();
        }
    }

    public void hH(int i) {
        if (i == 2) {
            this.bTU.CB();
            this.arn.BI();
        } else if (i == 5) {
            this.arn.BJ();
        } else if (i == 8) {
            this.arn.BK();
        } else if (i == 50) {
            this.arn.BM();
            this.bTU.CE();
        } else if (i == 44) {
            this.arn.BL();
            this.bTU.CC();
        } else if (i == 38) {
            this.arn.BH();
            this.bTU.CF();
        }
    }

    protected void afE() {
        this.bTU = (TbEditorToolButtonContainer) findViewById(com.baidu.tieba.v.write_eidtor_tool_buttons);
        this.bTU.Bh();
        this.bTU.bB(this.bTW == null);
        this.bTU.setAtFocusable(false);
        this.bTU.setOnActionListener(new bc(this));
        this.bTU.refresh();
    }

    public void hI(int i) {
        BaobaoSdkDelegate baobaoSdkDelegate;
        if (PluginHelper.isBaoBaoCanUse(this)) {
            if (this.arn.BO()) {
                hG(i);
            } else if (!com.baidu.tieba.e.a.adI() && this.bUb == 0) {
                showToast(com.baidu.tieba.y.baobao_over_limit);
            } else {
                String charSequence = this.awi.getText().toString();
                Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_BAOBAO);
                if (pluginByName != null && (baobaoSdkDelegate = (BaobaoSdkDelegate) pluginByName.getClassInstance(BaobaoSdkDelegate.class)) != null) {
                    baobaoSdkDelegate.startMatchImage(this, charSequence, 12013);
                }
            }
        }
    }

    public void b(com.baidu.tbadk.coreExtra.data.d dVar) {
        if (((ImageSpan[]) this.bJK.getText().getSpans(0, this.bJK.getText().length(), ImageSpan.class)).length >= 10) {
            if (this.bTS == null) {
                this.bTS = Toast.makeText(this, com.baidu.tieba.y.too_many_face, 0);
            }
            this.bTS.show();
            return;
        }
        String name = dVar.getName();
        EmotionGroupType oy = dVar.oy();
        if (name != null) {
            com.baidu.adp.lib.f.d.ef().a(name, 20, new bd(this, new SpannableStringBuilder(name), this.bJK.getSelectionStart(), oy), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        Bitmap hl = aVar.hl();
        com.baidu.tieba.view.v vVar = new com.baidu.tieba.view.v(hl);
        vVar.setBounds(0, 0, hl.getWidth() + 1, hl.getHeight());
        vVar.setGravity(3);
        spannableStringBuilder.setSpan(new ImageSpan(vVar, 0), 0, spannableStringBuilder.length(), 33);
        this.bJK.getText().insert(i, spannableStringBuilder);
    }

    public void afF() {
        this.bJK.onKeyDown(67, this.bTN);
    }

    private void f(Boolean bool) {
        String str = null;
        if (this.bpJ != null) {
            str = this.bpJ.getForumName();
        }
        if (com.baidu.tieba.e.b.b(str, bool)) {
            this.arn.Bt();
        } else {
            this.arn.Bs();
        }
    }

    private void afG() {
        getVoiceManager().onCreate(this);
    }

    private void afH() {
        try {
            if (this.bTP != null && this.bTP.isShowing()) {
                com.baidu.adp.lib.g.j.b(this.bTP, this);
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

    private Boolean afI() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.buT = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void acl() {
        String str = null;
        if (this.bpJ.getType() == 0) {
            String trim = this.bJG.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.bJr == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.bpJ.setIsNoTitle(true);
                    } else {
                        this.bpJ.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.bpJ.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.bpJ.setIsNoTitle(true);
            } else {
                this.bpJ.setIsNoTitle(false);
                str = "1";
            }
        }
        String trim2 = this.bJK.getText().toString().trim();
        if (this.arn.BN()) {
            str = "1";
        } else if (!TextUtils.isEmpty(trim2)) {
            str = "1";
        } else if (this.arn.BP()) {
            str = "1";
        } else if (this.arn.BO()) {
            str = "1";
        }
        if (str == null || str.length() <= 0) {
            this.bJL.setEnabled(false);
        } else {
            this.bJL.setEnabled(true);
        }
    }

    private void d(Bundle bundle) {
        this.ayI = new com.baidu.tieba.model.ar(this);
        this.ayI.a(this.ayL);
        registerListener(this.bUg);
        this.ayB = new com.baidu.tieba.location.d(this);
        this.ayB.a(this.ayM);
        this.bCv = new be(this);
        this.bpJ = new WriteData();
        if (bundle != null) {
            this.bpJ.setType(bundle.getInt("type", 0));
            this.bpJ.setForumId(bundle.getString("forum_id"));
            this.bpJ.setForumName(bundle.getString("forum_name"));
            this.bpJ.setThreadId(bundle.getString("thread_id"));
            this.bpJ.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.bpJ.setFloorNum(bundle.getInt(WriteActivityConfig.FLOOR_NUM, 0));
            this.bTJ = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.bTQ = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.bTR = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.baobaoImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.BAOBAO_IMAGES);
            this.ayG = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.bTW = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.bpJ.setIsAddition(this.bTW != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.bUb = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
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
                this.bpJ.setLiveCardData(liveCardData);
            }
        } else {
            Intent intent = getIntent();
            this.bpJ.setType(intent.getIntExtra("type", 0));
            this.bpJ.setForumId(intent.getStringExtra("forum_id"));
            this.bpJ.setForumName(intent.getStringExtra("forum_name"));
            this.bpJ.setThreadId(intent.getStringExtra("thread_id"));
            this.bpJ.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.bpJ.setFloorNum(intent.getIntExtra(WriteActivityConfig.FLOOR_NUM, 0));
            this.bTJ = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.bTQ = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.bTR = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.bTW = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.bpJ.setIsAddition(this.bTW != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.bUb = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
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
                this.bpJ.setLiveCardData(liveCardData2);
            }
        }
        this.baobaoImagesInfo.setMaxImagesAllowed(1);
        this.writeImagesInfo.setMaxImagesAllowed(10);
        this.bpJ.setWriteImagesInfo(this.writeImagesInfo);
        this.bpJ.setBaobaoImagesInfo(this.baobaoImagesInfo);
        if (this.bpJ.getType() == 0) {
            if (this.bpJ.getLiveCardData() == null) {
                com.baidu.tieba.util.l.b(this.bpJ.getForumId(), this);
            } else {
                com.baidu.tieba.util.l.a(this.bpJ.getLiveCardData().getGroupId(), this);
            }
        } else if (this.bpJ.getType() == 1) {
            com.baidu.tieba.util.l.a(this.bpJ.getThreadId(), this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getString(com.baidu.tieba.y.write_no_prefix));
        }
        this.aqi = TbadkApplication.m251getInst().getDefaultBubble();
        if (this.bpJ != null && this.bpJ.getForumName() != null && com.baidu.tieba.aj.wm().wY() != null && this.bpJ.getForumName().equals(com.baidu.tieba.aj.wm().wY())) {
            this.bTK = true;
        }
    }

    @Override // com.baidu.tieba.util.m
    public void a(WriteData writeData) {
        if (writeData != null && this.bpJ != null) {
            this.bpJ.setHaveDraft(true);
            if (com.baidu.adp.lib.util.l.aA(this.bJG.getText().toString()) || ((this.bTJ || this.bTK) && !com.baidu.adp.lib.util.l.aA(writeData.getTitle()))) {
                this.bpJ.setTitle(writeData.getTitle());
                this.bJG.setText(this.bpJ.getTitle());
                this.bJG.setSelection(this.bpJ.getTitle().length());
            }
            if (writeData.getLiveCardData() != null) {
                Date date = new Date(writeData.getLiveCardData().getStartTime() * 1000);
                Date date2 = new Date();
                date.setYear(date2.getYear());
                date.setMonth(date2.getMonth());
                date.setDate(date2.getDate());
                this.bpJ.getLiveCardData().setStartTime(date.getTime() / 1000);
                this.bUd.setText(com.baidu.tbadk.core.util.az.k(this.bpJ.getLiveCardData().getStartTime() * 1000));
            }
            if ((com.baidu.adp.lib.util.l.aA(this.bJK.getText().toString()) || this.bTJ || this.bTK) && !com.baidu.adp.lib.util.l.aA(writeData.getContent())) {
                this.bpJ.setContent(writeData.getContent());
                SpannableString a = TbFaceManager.sh().a(this, this.bpJ.getContent(), new bf(this));
                this.bJK.setText(a);
                this.bJK.setSelection(a.length());
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo = writeData.getWriteImagesInfo();
                this.bpJ.setWriteImagesInfo(this.writeImagesInfo);
                this.arn.a(this.writeImagesInfo, true);
                eN(false);
            }
            if (TbadkApplication.m251getInst().isBaobaoShouldOpen()) {
                if (writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                    this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                    this.bpJ.setIsBaobao(writeData.getIsBaobao());
                    this.bpJ.setBaobaoContent(writeData.getBaobaoContent());
                    this.bpJ.setBaobaoImagesInfo(this.baobaoImagesInfo);
                }
                if (this.bpJ.getIsBaobao()) {
                    this.arn.setBaobaoUris(this.baobaoImagesInfo);
                    eO(false);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.bpJ.getType());
        bundle.putString("forum_id", this.bpJ.getForumId());
        bundle.putString("forum_name", this.bpJ.getForumName());
        bundle.putString("thread_id", this.bpJ.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.bpJ.getFloor());
        bundle.putInt(WriteActivityConfig.FLOOR_NUM, this.bpJ.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.bTQ);
        if (this.bTJ) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putSerializable(WriteActivityConfig.BAOBAO_IMAGES, this.baobaoImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.ayG);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.bTW);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.bUb);
        if (this.bpJ.getLiveCardData() != null) {
            bundle.putBoolean(WriteActivityConfig.IS_LIVE_POST, true);
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ID, this.bpJ.getLiveCardData().getGroupId());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_HEAD, this.bpJ.getLiveCardData().getPortrait());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_INTRO, this.bpJ.getLiveCardData().getIntro());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_NAME, this.bpJ.getLiveCardData().getName());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_MEMBER_COUNT, this.bpJ.getLiveCardData().getListeners());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ZAN_COUNT, this.bpJ.getLiveCardData().getLikers());
            bundle.putLong(WriteActivityConfig.LIVE_DATE, this.bpJ.getLiveCardData().getStartTime());
            bundle.putBoolean(WriteActivityConfig.LIVE_TIME_IS_MODIFY, this.bpJ.getLiveCardData().isModifyTime());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_PUBLISH_HEAD, this.bpJ.getLiveCardData().getPublisherPortrait());
        }
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(this);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = this.bJK.getEditableText().toString();
        if (editable != null) {
            this.bJK.setText(TbFaceManager.sh().q(this, editable));
            this.bJK.setSelection(this.bJK.getText().length());
        }
    }

    public void acg() {
        acd();
        if (this.bpJ.getLiveCardData() != null) {
            if (!this.bpJ.getLiveCardData().isModifyTime()) {
                this.bpJ.getLiveCardData().setStartTime(new Date().getTime() / 1000);
                this.bUd.setText(com.baidu.tbadk.core.util.az.k(this.bpJ.getLiveCardData().getStartTime() * 1000));
            }
            long time = new Date().getTime() / TbConfig.USE_TIME_INTERVAL;
            Date date = new Date(this.bpJ.getLiveCardData().getStartTime() * 1000);
            Date date2 = new Date();
            date.setYear(date2.getYear());
            date.setMonth(date2.getMonth());
            date.setDate(date2.getDate());
            this.bpJ.getLiveCardData().setStartTime(date.getTime() / 1000);
            if (time > this.bpJ.getLiveCardData().getStartTime() / 60) {
                showToast(com.baidu.tieba.y.live_start_time_error);
                return;
            }
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.bJr != this.mPrefixData.getPrefixs().size() - 1) {
            this.bpJ.setTitle(String.valueOf(this.bJM.getText().toString()) + this.bJG.getText().toString());
        } else {
            this.bpJ.setTitle(this.bJG.getText().toString());
        }
        this.bpJ.setContent(this.bJK.getText().toString());
        if (this.bTJ || this.bTK) {
            String string = getResources().getString(com.baidu.tieba.y.android_feedback);
            if (TextUtils.isEmpty(this.bpJ.getTitle()) || !this.bpJ.getTitle().startsWith(string)) {
                this.bpJ.setTitle(string + this.bpJ.getTitle());
            }
            String string2 = getResources().getString(com.baidu.tieba.y.tieba_client);
            if (TextUtils.isEmpty(this.bpJ.getContent()) || !this.bpJ.getContent().startsWith(string2)) {
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
                sb.append(this.bpJ.getContent());
                this.bpJ.setContent(sb.toString());
            }
        }
        this.bpJ.setWriteImagesInfo(this.writeImagesInfo);
        this.bpJ.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.bpJ.setHasLocationData(this.bTT.getLocationInfoViewState() == 2);
        this.ayI.dI(this.writeImagesInfo.size() > 0);
        this.ayI.b(this.bpJ);
        VoiceData.VoiceModel audioData = this.arn.getAudioData();
        this.arn.BS();
        this.bpJ.setVcode(null);
        if (audioData != null) {
            if (audioData.getId() != null) {
                this.ayI.EE().setVoice(audioData.getId());
                this.ayI.EE().setVoiceDuringTime(audioData.duration);
            } else {
                this.ayI.EE().setVoice(null);
                this.ayI.EE().setVoiceDuringTime(-1);
            }
        } else {
            this.ayI.EE().setVoice(null);
            this.ayI.EE().setVoiceDuringTime(-1);
        }
        if (!this.ayI.TV()) {
            showToast(com.baidu.tieba.y.write_img_limit);
        } else if (this.ayI.TU()) {
            showLoadingDialog(getString(com.baidu.tieba.y.sending), this.bCv);
        }
    }

    private void h(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.bTW != null) {
                i2 = this.bTW.getTotalCount();
                i = this.bTW.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getString(com.baidu.tieba.y.write_addition_left_count), Integer.valueOf(i2 - i)));
            }
        }
        com.baidu.adp.lib.util.m.showToast(this, sb.toString());
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
                            this.bJK.getText().insert(this.bJK.getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                if (this.bpJ.getType() == 0) {
                    com.baidu.tieba.util.l.a(this.bpJ.getForumId(), (WriteData) null);
                } else if (this.bpJ.getType() == 1) {
                    com.baidu.tieba.util.l.b(this.bpJ.getThreadId(), (WriteData) null);
                }
                setResult(-1);
                finish();
            } else if (i == 12002) {
                e(intent);
                acl();
                this.arn.setVisibility(0);
            } else if (i == 12001) {
                g(intent);
                int size2 = this.writeImagesInfo.size() - 1;
                if (size2 > -1 && this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this, 12012, this.writeImagesInfo, size2)));
                }
            } else if (i == 12012) {
                f(intent);
                acl();
            } else if (i == 12013) {
                h(intent);
                acl();
            } else if (i == 23004) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    EF();
                    return;
                case 12002:
                    if (!this.arn.BN()) {
                        afC();
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
                    this.ayG = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.av.a(this, this.ayG);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.bJG);
        HidenSoftKeyPad(this.mInputManager, this.bJK);
        super.onPause();
        getVoiceManager().onPause(this);
    }

    private void e(Intent intent) {
        b(intent, true);
    }

    private void g(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.ayG;
        if (!TextUtils.isEmpty(str)) {
            try {
                int bl = com.baidu.tbadk.core.util.d.bl(str);
                if (bl != 0) {
                    Bitmap a = com.baidu.tbadk.core.util.d.a(str, com.baidu.adp.lib.util.m.dip2px(this, com.baidu.adp.lib.util.m.n(this)), com.baidu.adp.lib.util.m.dip2px(this, com.baidu.adp.lib.util.m.o(this)));
                    Bitmap e = com.baidu.tbadk.core.util.d.e(a, bl);
                    if (a != e) {
                        a.recycle();
                    }
                    com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.ayG, e, 100);
                    e.recycle();
                }
            } catch (Exception e2) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            this.arn.a(this.writeImagesInfo, true);
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
                    this.arn.a(this.writeImagesInfo, z);
                }
            }
            eN(true);
        }
    }

    private void h(Intent intent) {
        if (this.bpJ != null) {
            String stringExtra = intent.getStringExtra(BaobaoSdkDelegate.KEY_BITMAPPATH);
            String stringExtra2 = intent.getStringExtra(BaobaoSdkDelegate.KEY_CONTENT);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(stringExtra);
            this.baobaoImagesInfo.clear();
            this.baobaoImagesInfo.addChooseFile(imageFileInfo);
            this.bpJ.setIsBaobao(true);
            this.bpJ.setBaobaoContent(stringExtra2);
            this.arn.setBaobaoUris(this.baobaoImagesInfo);
            eO(true);
        }
    }

    private void EF() {
        new bg(this).execute(new Void[0]);
    }

    private void eN(boolean z) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() > 0) {
            this.bTU.di(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            this.bTV = true;
            this.arn.di(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            if (this.arn.BD() || z) {
                this.arn.BK();
                return;
            }
            return;
        }
        this.bTU.rF();
        this.bTV = false;
        this.arn.rF();
        if (this.arn.BP()) {
            this.bTU.Cn();
            this.arn.rN();
        }
        afC();
    }

    private void eO(boolean z) {
        LinkedList<ImageFileInfo> chosedFiles = this.baobaoImagesInfo.getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() > 0) {
            this.bTU.CE();
            this.bTU.dk("1");
            if (this.arn.BD() || z) {
                this.arn.BM();
            }
            this.bpJ.setIsBaobao(true);
            return;
        }
        this.bTU.rM();
        this.bpJ.setIsBaobao(false);
        this.bTU.CD();
        afC();
    }

    @Override // com.baidu.tbadk.core.voice.o
    public synchronized VoiceManager getVoiceManager() {
        if (this.ayx == null) {
            this.ayx = VoiceManager.instance();
        }
        return this.ayx;
    }

    @Override // com.baidu.tbadk.core.voice.o
    public com.baidu.tbadk.core.voice.m b(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public synchronized void EC() {
        this.ayx = getVoiceManager();
        this.ayx.stopPlay();
    }

    public void a(boolean z, AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.bpJ.getForumName());
            AntiHelper.a(this, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.WRITE);
        } else if (this.bTW == null) {
            ck.J(this, str);
        } else {
            h(z, str);
        }
    }

    @Override // com.baidu.tieba.write.ci
    public void hj(int i) {
        this.bJr = i;
        this.bJN.dP(i);
        this.bJM.setText(this.mPrefixData.getPrefixs().get(i));
        acl();
        com.baidu.adp.lib.g.j.a(this.bJN, this);
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.bJP.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.GX.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
