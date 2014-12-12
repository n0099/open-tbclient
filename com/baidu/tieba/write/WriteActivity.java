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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
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
import com.baidu.tbadk.core.util.httpNet.CDNIPDirectConnect;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoContainer;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.tbadkCore.PbEditor.TbEditorToolButtonContainer;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, com.baidu.tbadk.core.voice.o, com.baidu.tieba.tbadkCore.am, ci {
    private com.baidu.tieba.tbadkCore.location.d aAD;
    private String aAI;
    private com.baidu.tieba.tbadkCore.f.a aAK;
    private int bNG;
    private View bNY;
    private TextView bOc;
    private ch bOd;
    private ImageView bOe;
    private View bOf;
    private Toast ceZ;
    private AdditionData cfd;
    private RelativeLayout cfe;
    private TextView cff;
    private TextView cfg;
    private TextView cfh;
    private RelativeLayout cfj;
    private TextView cfk;
    private View cfl;
    private LiveBroadcastCard cfm;
    private com.baidu.tieba.view.b cfs;
    private GestureDetector mGestureDetector;
    private PostPrefixData mPrefixData;
    private VoiceManager mVoiceManager;
    private WriteData bNF = null;
    private boolean ceQ = false;
    private boolean ceR = false;
    private InputMethodManager mInputManager = null;
    private EditText bNW = null;
    private View bNX = null;
    private LinearLayout bNZ = null;
    private EditText bOa = null;
    private AlertDialog aAR = null;
    private o ceS = null;
    private FeedBackTopListView ceT = null;
    private String bTi = null;
    private final KeyEvent ceU = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView ceV = null;
    private TextView bOb = null;
    private TextView azp = null;
    private DialogInterface.OnCancelListener bFV = null;
    private AlertDialog ceW = null;
    private final Handler mHandler = new Handler();
    private boolean ceX = false;
    private String ceY = null;
    private RelativeLayout mParent = null;
    private String byI = null;
    private com.baidu.tieba.tbadkCore.PbEditor.k cfa = null;
    private TbEditorToolButtonContainer cfb = null;
    private EditorToolComponetContainer bUs = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private boolean cfc = false;
    private int cfi = 0;
    private HttpMessageListener cfn = new ac(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private final com.baidu.tieba.tbadkCore.f.c aCB = new an(this);
    private com.baidu.tieba.tbadkCore.location.i aAO = new az(this);
    private View.OnClickListener cfo = new bh(this);
    private CustomMessageListener bYz = new bi(this, 2001232);
    private final Runnable cfp = new bj(this);
    private final View.OnClickListener cfq = new bk(this);
    private boolean cfr = true;
    private final View.OnFocusChangeListener bNU = new bl(this);
    private com.baidu.tieba.tbadkCore.bubble.y aFe = new bm(this);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(WriteActivityConfig.class, WriteActivity.class);
        com.baidu.tieba.tbadkCore.location.d.ahE();
    }

    public void EQ() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void ER() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(com.baidu.tieba.z.location_system_permission_prompt);
            this.cfa.setLocationInfoViewState(0);
        } else if (!TbadkCoreApplication.m255getInst().getLocationShared()) {
            ES();
        } else if (this.aAD.ahD()) {
            EQ();
        } else {
            this.aAD.ex(false);
            this.cfa.setLocationInfoViewState(1);
            this.aAD.ahB();
        }
    }

    private void ES() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bt(com.baidu.tieba.z.location_app_permission_prompt).a(com.baidu.tieba.z.isopen, new ad(this)).b(com.baidu.tieba.z.cancel, new ae(this)).b(getPageContext());
        aVar.nU();
    }

    public int ajX() {
        int selectionEnd = this.bOa.getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) this.bOa.getText().getSpans(0, this.bOa.getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = this.bOa.getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = this.bOa.getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    public void ajY() {
        if (!this.cfr) {
            this.cfb.aeQ();
        } else {
            this.cfb.aeR();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        this.bUs.afy();
        if (this.cfs != null && this.bNF != null && this.bNF.getLiveCardData() != null) {
            new Handler().postDelayed(new af(this, new Date(this.bNF.getLiveCardData().getStartTime() * 1000)), 100L);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.bUs.afw();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BdLog.addLogPackage(WriteActivity.class.getPackage().getName());
        super.onCreate(bundle);
        registerListener(this.bYz);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new bn(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        initUI();
        akc();
        if (this.cfd == null) {
            ET();
        }
    }

    private void ET() {
        if (this.aAD.ahF()) {
            if (this.aAD.ahD()) {
                this.cfa.B(2, com.baidu.tieba.tbadkCore.location.c.ahy().getLocationData().ahu());
                return;
            }
            this.cfa.setLocationInfoViewState(1);
            this.aAD.ahB();
            return;
        }
        this.cfa.setLocationInfoViewState(0);
    }

    public void acy() {
        if (this.aAK != null) {
            this.aAK.cancelLoadData();
        }
        if (this.ceS != null) {
            this.ceS.cancelLoadData();
        }
        if (this.aAD != null) {
            this.aAD.cancelLoadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        acy();
        akl();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
    }

    public void ajZ() {
        if (this.bNF != null && this.bNF.getType() == 2 && this.ceX) {
            finish();
        } else if (this.bNF == null) {
            finish();
        } else {
            this.bNF.setTitle(this.bNW.getText().toString());
            this.bNF.setContent(this.bOa.getText().toString());
            int type = this.bNF.getType();
            if (this.bNF.getHaveDraft() && com.baidu.adp.lib.util.k.isEmpty(this.bNF.getTitle()) && com.baidu.adp.lib.util.k.isEmpty(this.bNF.getContent()) && !this.bNF.isHasImages()) {
                if (type == 0) {
                    if (this.bNF.getLiveCardData() == null) {
                        com.baidu.tieba.tbadkCore.al.a(this.bNF.getForumId(), (WriteData) null);
                    } else {
                        com.baidu.tieba.tbadkCore.al.a(this.bNF.getLiveCardData().getGroupId(), (WriteData) null);
                    }
                } else if (type == 1) {
                    com.baidu.tieba.tbadkCore.al.b(this.bNF.getThreadId(), (WriteData) null);
                }
            } else if (type == 0) {
                if (this.bNF.getLiveCardData() == null) {
                    com.baidu.tieba.tbadkCore.al.a(this.bNF.getForumId(), this.bNF);
                } else {
                    com.baidu.tieba.tbadkCore.al.a(this.bNF.getLiveCardData().getGroupId(), this.bNF);
                }
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.al.b(this.bNF.getThreadId(), this.bNF);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bOd != null && this.bOd.isShowing()) {
                com.baidu.adp.lib.g.k.a(this.bOd, getPageContext().getPageActivity());
                return true;
            } else if (this.bUs.afj()) {
                this.cfb.aeS();
                this.bUs.hideAll();
                return true;
            } else {
                acy();
                ajZ();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.ax.g(this.bOb, i);
        ajY();
        com.baidu.tbadk.core.util.ax.j(this.bNX, com.baidu.tieba.t.cp_bg_line_c);
        com.baidu.tbadk.core.util.ax.j(this.bNY, com.baidu.tieba.t.cp_bg_line_c);
        com.baidu.tbadk.core.util.ax.j((View) this.bNW, com.baidu.tieba.t.cp_bg_line_d);
        if (TextUtils.isEmpty(this.bTi)) {
            com.baidu.tbadk.core.util.ax.j((View) this.bOa, com.baidu.tieba.t.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.ax.getColor(com.baidu.tieba.t.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.ax.getColor(com.baidu.tieba.t.cp_cont_e);
        this.cfb.changeSkinType(i);
        this.bNW.setTextColor(color);
        this.bOa.setTextColor(color);
        a(this.bNW, color2);
        a(this.bOa, color2);
        acG();
        this.bUs.onChangeSkinType(i);
        this.cfa.wc();
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
        setContentView(com.baidu.tieba.x.write_activity);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.azp = this.mNavigationBar.setTitleText("");
        this.ceV = (TextView) findViewById(com.baidu.tieba.w.btn_image_problem);
        this.bOb = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(com.baidu.tieba.z.send));
        this.bOb.setOnFocusChangeListener(this.bNU);
        addGlobalLayoutListener();
        this.ceT = (FeedBackTopListView) findViewById(com.baidu.tieba.w.feedback_top_list);
        this.mParent = (RelativeLayout) findViewById(com.baidu.tieba.w.parent);
        this.bNX = findViewById(com.baidu.tieba.w.interval_view);
        this.bNY = findViewById(com.baidu.tieba.w.prefix_interval_view);
        acF();
        this.mHandler.postDelayed(this.cfp, 200L);
        acH();
        if (this.ceQ || this.ceR) {
            getWindow().setSoftInputMode(18);
            if (CDNIPDirectConnect.pM().hasImageProblem()) {
                findViewById(com.baidu.tieba.w.ll_image_problem).setVisibility(0);
            } else {
                findViewById(com.baidu.tieba.w.ll_image_problem).setVisibility(8);
            }
        }
        this.bNZ = (LinearLayout) findViewById(com.baidu.tieba.w.post_content_container);
        this.bNZ.setDrawingCacheEnabled(false);
        this.bNZ.setOnClickListener(new ag(this));
        this.mBack.setOnFocusChangeListener(this.bNU);
        this.mBack.setOnClickListener(new ah(this));
        this.ceV.setOnClickListener(new ai(this));
        this.cfa = new com.baidu.tieba.tbadkCore.PbEditor.k((EditorInfoContainer) findViewById(com.baidu.tieba.w.write_editor_info));
        this.cfa.G(this.cfo);
        if (this.cfd != null) {
            this.cfa.destroy();
        }
        aki();
        akf();
        akd();
        boolean appResponseToCmd = TbadkCoreApplication.m255getInst().appResponseToCmd(2802001);
        if (!TbadkCoreApplication.m255getInst().isBaobaoShouldOpen() || this.cfd != null || !appResponseToCmd) {
            this.cfb.agg();
        }
        if (this.bNF.getType() == 0) {
            if (this.ceQ || this.ceR) {
                this.cfb.agg();
                this.azp.setText(com.baidu.tieba.z.feedback);
            } else {
                this.azp.setText(com.baidu.tieba.z.post_new_thread);
            }
            this.bNW.setVisibility(0);
            this.bOa.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
        } else {
            this.azp.setText(com.baidu.tieba.z.send_reply);
            this.bOa.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
            this.bNW.setVisibility(8);
        }
        ake();
        akk();
        g(akm());
        ajY();
        akb();
        acE();
        aka();
        acG();
        if (this.bNF.getLiveCardData() == null) {
            ShowSoftKeyPad(this.mInputManager, this.bNW);
        }
    }

    private void aka() {
        this.cfj = (RelativeLayout) findViewById(com.baidu.tieba.w.live_time_rel);
        this.cfk = (TextView) findViewById(com.baidu.tieba.w.live_tiem_show);
        this.cfl = findViewById(com.baidu.tieba.w.interval_view2);
        this.cfm = (LiveBroadcastCard) findViewById(com.baidu.tieba.w.live_anchor_card);
        this.cfj.setOnClickListener(new aj(this));
        this.cfj.setOnTouchListener(new ak(this));
        if (this.bNF.getLiveCardData() != null) {
            this.cfj.setVisibility(0);
            this.cfl.setVisibility(0);
            this.cfm.setVisibility(0);
            this.cfm.setClickable(false);
            this.cfk.setText(com.baidu.tbadk.core.util.ba.o(this.bNF.getLiveCardData().getStartTime() * 1000));
            this.cfm.setData(this.bNF.getLiveCardData());
            return;
        }
        this.cfj.setVisibility(8);
        this.cfl.setVisibility(8);
        this.cfm.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if ((dialog instanceof com.baidu.tieba.view.b) && this.bNF.getLiveCardData() != null) {
            Date date = new Date(this.bNF.getLiveCardData().getStartTime() * 1000);
            ((com.baidu.tieba.view.b) dialog).updateTime(date.getHours(), date.getMinutes());
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.cfs = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new al(this), new Date().getHours(), new Date().getMinutes(), false);
        this.cfs.setTitle(com.baidu.tieba.z.no_disturb_start_time);
        this.cfs.setButton(-1, getPageContext().getString(com.baidu.tieba.z.alert_yes_button), this.cfs);
        this.cfs.setButton(-2, getPageContext().getString(com.baidu.tieba.z.alert_no_button), this.cfs);
        return this.cfs;
    }

    private void akb() {
        this.cfe = (RelativeLayout) findViewById(com.baidu.tieba.w.addition_container);
        this.cff = (TextView) findViewById(com.baidu.tieba.w.addition_create_time);
        this.cfg = (TextView) findViewById(com.baidu.tieba.w.addition_last_time);
        this.cfh = (TextView) findViewById(com.baidu.tieba.w.addition_last_content);
        if (this.cfd != null) {
            this.cfe.setVisibility(0);
            this.cff.setText(String.valueOf(getPageContext().getString(com.baidu.tieba.z.write_addition_create)) + com.baidu.tbadk.core.util.ba.n(this.cfd.getCreateTime() * 1000));
            if (this.cfd.getAlreadyCount() == 0) {
                this.cfg.setVisibility(8);
            } else {
                this.cfg.setText(String.valueOf(getPageContext().getString(com.baidu.tieba.z.write_addition_last)) + com.baidu.tbadk.core.util.ba.n(this.cfd.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.cfd.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.cfh.setText(lastAdditionContent);
            } else {
                this.cfh.setVisibility(8);
            }
            this.bOa.setHint(String.format(getPageContext().getString(com.baidu.tieba.z.write_addition_hint), Integer.valueOf(this.cfd.getAlreadyCount()), Integer.valueOf(this.cfd.getTotalCount())));
            this.azp.setText(com.baidu.tieba.z.write_addition_title);
            return;
        }
        this.cfe.setVisibility(8);
    }

    private void acE() {
        this.bOf = findViewById(com.baidu.tieba.w.post_prefix_layout);
        this.bOc = (TextView) findViewById(com.baidu.tieba.w.post_prefix);
        this.bOe = (ImageView) findViewById(com.baidu.tieba.w.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.bOf.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.bOc.setText(prefixs.get(0));
            this.bNG = 0;
            this.bOf.setOnClickListener(new am(this));
            this.bOe = (ImageView) findViewById(com.baidu.tieba.w.prefix_icon);
            if (size > 1) {
                this.bOe.setVisibility(0);
                this.bOc.setOnClickListener(new ao(this));
            }
            this.bOd = new ch(getPageContext().getPageActivity());
            this.bOd.a(this);
            this.bOd.setMaxHeight(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 225.0f));
            this.bOd.setOutsideTouchable(true);
            this.bOd.setFocusable(true);
            this.bOd.setOnDismissListener(this);
            this.bOd.setBackgroundDrawable(com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.t.cp_bg_line_b));
            int color = com.baidu.tbadk.core.util.ax.getColor(com.baidu.tieba.t.write_text);
            com.baidu.tbadk.core.util.ax.i((View) this.bOc, com.baidu.tieba.v.write_prefix_item_selector);
            com.baidu.tbadk.core.util.ax.c(this.bOe, com.baidu.tieba.v.icon_title_down);
            this.bOc.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                com.baidu.tbadk.core.util.ax.i((View) textView, com.baidu.tieba.v.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), getResources().getDimension(com.baidu.tieba.u.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), getResources().getDimension(com.baidu.tieba.u.ds22)), 0);
                this.bOd.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), getResources().getDimension(com.baidu.tieba.u.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), getResources().getDimension(com.baidu.tieba.u.ds22)), 0);
                }
            }
            this.bOd.setCurrentIndex(0);
            return;
        }
        this.bOf.setVisibility(8);
    }

    private void akc() {
        if (this.ceQ && this.bNF != null) {
            this.ceT.setVisibility(0);
            this.ceS = new o(this);
            this.ceS.iv(this.bNF.getForumName());
            this.ceS.setLoadDataCallBack(new ap(this));
        }
    }

    public void EU() {
        if (this.aAR == null) {
            String[] strArr = {getPageContext().getString(com.baidu.tieba.z.take_photo), getPageContext().getString(com.baidu.tieba.z.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getPageActivity());
            builder.setTitle(getPageContext().getString(com.baidu.tieba.z.operation));
            builder.setItems(strArr, new aq(this));
            this.aAR = builder.create();
            this.aAR.setCanceledOnTouchOutside(true);
        }
    }

    protected void akd() {
        this.bOb.setOnClickListener(new ar(this));
    }

    protected void ake() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getPageActivity());
        builder.setMessage(getPageContext().getString(com.baidu.tieba.z.is_save_draft)).setCancelable(false).setPositiveButton(getPageContext().getString(com.baidu.tieba.z.save), new as(this)).setNeutralButton(getPageContext().getString(com.baidu.tieba.z.not_save), new au(this));
        this.ceW = builder.create();
    }

    protected void acF() {
        this.bNW = (EditText) findViewById(com.baidu.tieba.w.post_title);
        this.bNW.setOnClickListener(this.cfq);
        this.bNW.setOnFocusChangeListener(this.bNU);
        if (this.bNF.getType() == 0) {
            if (this.bNF.getTitle() != null) {
                this.bNW.setText(this.bNF.getTitle());
                this.bNW.setSelection(this.bNF.getTitle().length());
            }
        } else if (this.bNF.getType() != 1) {
            this.bNF.getType();
        }
        this.bNW.addTextChangedListener(new av(this));
    }

    protected void acH() {
        this.bOa = (EditText) findViewById(com.baidu.tieba.w.post_content);
        this.bOa.setDrawingCacheEnabled(false);
        this.bOa.setOnClickListener(this.cfq);
        if (this.bNF.getContent() != null && this.bNF.getContent().length() > 0) {
            SpannableString F = TbFaceManager.vK().F(getPageContext().getPageActivity(), this.bNF.getContent());
            this.bOa.setText(F);
            this.bOa.setSelection(F.length());
        } else if (this.bNF.getType() == 2) {
            if (this.ceX) {
                if (this.ceY != null && this.ceY.length() > 0) {
                    this.bOa.setText(getPageContext().getPageActivity().getString(com.baidu.tieba.z.reply_sub_floor, new Object[]{this.ceY}));
                    this.bOa.setSelection(this.bOa.getText().length());
                }
            } else if (this.bNF.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(com.baidu.tieba.z.reply_x_floor), Integer.valueOf(this.bNF.getFloorNum()));
                this.bOa.setText(format);
                this.bOa.setSelection(format.length());
            }
        }
        this.bOa.setOnFocusChangeListener(this.bNU);
        this.bOa.setOnTouchListener(new aw(this));
        this.bOa.addTextChangedListener(new ax(this));
        eL(true);
    }

    public void eL(boolean z) {
        this.bOa.setPadding(0, 0, 0, 0);
        this.bOa.setBackgroundDrawable(null);
        com.baidu.tbadk.core.util.ax.j((View) this.bOa, com.baidu.tieba.t.cp_bg_line_d);
        if (!TextUtils.isEmpty(this.bTi) && this.cfd == null) {
            com.baidu.adp.lib.f.d.ee().a(this.bTi, 19, new ay(this, z), getUniqueId());
        }
    }

    public boolean Fl() {
        int i = 5000;
        if (this.cfd != null) {
            i = 1000;
        }
        return this.bOa.getText() != null && this.bOa.getText().length() >= i;
    }

    protected void akf() {
        this.bUs = (EditorToolComponetContainer) findViewById(com.baidu.tieba.w.tool_group);
        this.bUs.setFrom(1);
        this.bUs.vr();
        this.bUs.setOnActionListener(new ba(this));
    }

    protected void akg() {
        this.cfb.aeS();
        if (this.bUs.afj()) {
            this.bUs.hideAll();
        }
    }

    public void akh() {
        this.bUs.V(this.bOa);
    }

    public void io(int i) {
        if (this.bUs.afj()) {
            ip(i);
            return;
        }
        this.bUs.U(this.bNW);
        this.bUs.U(this.bOa);
        new Handler().postDelayed(new bb(this, i), 200L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
        if (this.bUs != null) {
            this.bUs.afl();
        }
    }

    public void ip(int i) {
        if (i == 2) {
            this.cfb.aga();
            this.bUs.afn();
        } else if (i == 5) {
            this.bUs.afo();
        } else if (i == 8) {
            this.bUs.afp();
        } else if (i == 50) {
            this.bUs.afr();
            this.cfb.agd();
        } else if (i == 44) {
            this.bUs.afq();
            this.cfb.agb();
        } else if (i == 38) {
            this.bUs.afm();
            this.cfb.age();
        }
    }

    protected void aki() {
        this.cfb = (TbEditorToolButtonContainer) findViewById(com.baidu.tieba.w.write_eidtor_tool_buttons);
        this.cfb.aeR();
        this.cfb.es(this.cfd == null);
        this.cfb.setAtFocusable(false);
        this.cfb.setOnActionListener(new bc(this));
        if (TbadkCoreApplication.m255getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.cfb.es(false);
            this.cfb.vj();
        }
        this.cfb.refresh();
    }

    public void iq(int i) {
        if (this.bUs.aft()) {
            io(i);
        } else if (!com.baidu.tieba.tbadkCore.PbEditor.a.aeH() && this.cfi == 0) {
            showToast(com.baidu.tieba.z.baobao_over_limit);
        } else {
            String charSequence = this.azp.getText().toString();
            com.baidu.tbadk.core.frameworkData.a aVar = new com.baidu.tbadk.core.frameworkData.a(getPageContext().getPageActivity());
            aVar.getIntent().putExtra("title", charSequence);
            aVar.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
            sendMessage(new CustomMessage(2802001, aVar));
        }
    }

    public void a(com.baidu.tbadk.coreExtra.data.f fVar) {
        if (((ImageSpan[]) this.bOa.getText().getSpans(0, this.bOa.getText().length(), ImageSpan.class)).length >= 10) {
            if (this.ceZ == null) {
                this.ceZ = Toast.makeText(getPageContext().getPageActivity(), com.baidu.tieba.z.too_many_face, 0);
            }
            this.ceZ.show();
            return;
        }
        String name = fVar.getName();
        EmotionGroupType rz = fVar.rz();
        if (name != null) {
            com.baidu.adp.lib.f.d.ee().a(name, 20, new bd(this, new SpannableStringBuilder(name), this.bOa.getSelectionStart(), rz), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        Bitmap ji = aVar.ji();
        com.baidu.tieba.view.l lVar = new com.baidu.tieba.view.l(ji);
        lVar.setBounds(0, 0, ji.getWidth() + 1, ji.getHeight());
        lVar.setGravity(3);
        spannableStringBuilder.setSpan(new ImageSpan(lVar, 0), 0, spannableStringBuilder.length(), 33);
        this.bOa.getText().insert(i, spannableStringBuilder);
    }

    public void akj() {
        this.bOa.onKeyDown(67, this.ceU);
    }

    private void g(Boolean bool) {
        String str = null;
        if (this.bNF != null) {
            str = this.bNF.getForumName();
        }
        if (com.baidu.tieba.tbadkCore.aa.b(str, bool)) {
            this.bUs.Wz();
        } else {
            this.bUs.Wy();
        }
    }

    private void akk() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void akl() {
        try {
            if (this.ceW != null && this.ceW.isShowing()) {
                com.baidu.adp.lib.g.k.b(this.ceW, getPageContext());
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

    private Boolean akm() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.byI = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void acG() {
        String str = null;
        if (this.bNF.getType() == 0) {
            String trim = this.bNW.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.bNG == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.bNF.setIsNoTitle(true);
                    } else {
                        this.bNF.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.bNF.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.bNF.setIsNoTitle(true);
            } else {
                this.bNF.setIsNoTitle(false);
                str = "1";
            }
        }
        String trim2 = this.bOa.getText().toString().trim();
        if (this.bUs.afs()) {
            str = "1";
        } else if (!TextUtils.isEmpty(trim2)) {
            str = "1";
        } else if (this.bUs.afu()) {
            str = "1";
        } else if (this.bUs.aft()) {
            str = "1";
        }
        if (str == null || str.length() <= 0) {
            this.bOb.setEnabled(false);
        } else {
            this.bOb.setEnabled(true);
        }
    }

    private void initData(Bundle bundle) {
        this.aAK = new com.baidu.tieba.tbadkCore.f.a(this);
        this.aAK.a(this.aCB);
        registerListener(this.cfn);
        this.aAD = new com.baidu.tieba.tbadkCore.location.d(this);
        this.aAD.a(this.aAO);
        this.bFV = new be(this);
        this.bNF = new WriteData();
        if (bundle != null) {
            this.bNF.setType(bundle.getInt("type", 0));
            this.bNF.setForumId(bundle.getString("forum_id"));
            this.bNF.setForumName(bundle.getString("forum_name"));
            this.bNF.setThreadId(bundle.getString("thread_id"));
            this.bNF.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.bNF.setFloorNum(bundle.getInt(WriteActivityConfig.FLOOR_NUM, 0));
            this.ceQ = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.ceX = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.ceY = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.baobaoImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.BAOBAO_IMAGES);
            this.aAI = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.cfd = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.bNF.setIsAddition(this.cfd != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.cfi = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
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
                this.bNF.setLiveCardData(liveCardData);
            }
        } else {
            Intent intent = getIntent();
            this.bNF.setType(intent.getIntExtra("type", 0));
            this.bNF.setForumId(intent.getStringExtra("forum_id"));
            this.bNF.setForumName(intent.getStringExtra("forum_name"));
            this.bNF.setThreadId(intent.getStringExtra("thread_id"));
            this.bNF.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.bNF.setFloorNum(intent.getIntExtra(WriteActivityConfig.FLOOR_NUM, 0));
            this.ceQ = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.ceX = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.ceY = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.cfd = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.bNF.setIsAddition(this.cfd != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.cfi = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
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
                this.bNF.setLiveCardData(liveCardData2);
            }
        }
        this.baobaoImagesInfo.setMaxImagesAllowed(1);
        this.writeImagesInfo.setMaxImagesAllowed(10);
        this.bNF.setWriteImagesInfo(this.writeImagesInfo);
        this.bNF.setBaobaoImagesInfo(this.baobaoImagesInfo);
        if (this.bNF.getType() == 0) {
            if (this.bNF.getLiveCardData() == null) {
                com.baidu.tieba.tbadkCore.al.b(this.bNF.getForumId(), this);
            } else {
                com.baidu.tieba.tbadkCore.al.a(this.bNF.getLiveCardData().getGroupId(), this);
            }
        } else if (this.bNF.getType() == 1) {
            com.baidu.tieba.tbadkCore.al.a(this.bNF.getThreadId(), this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(com.baidu.tieba.z.write_no_prefix));
        }
        this.bTi = TbadkCoreApplication.m255getInst().getDefaultBubble();
        if (this.bNF != null && this.bNF.getForumName() != null && TbadkCoreApplication.m255getInst().getYijianfankuiFname() != null && this.bNF.getForumName().equals(TbadkCoreApplication.m255getInst().getYijianfankuiFname())) {
            this.ceR = true;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.am
    public void a(WriteData writeData) {
        if (writeData != null && this.bNF != null) {
            this.bNF.setHaveDraft(true);
            if (com.baidu.adp.lib.util.k.isEmpty(this.bNW.getText().toString()) || ((this.ceQ || this.ceR) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                this.bNF.setTitle(writeData.getTitle());
                this.bNW.setText(this.bNF.getTitle());
                this.bNW.setSelection(this.bNF.getTitle().length());
            }
            if (writeData.getLiveCardData() != null) {
                Date date = new Date(writeData.getLiveCardData().getStartTime() * 1000);
                Date date2 = new Date();
                date.setYear(date2.getYear());
                date.setMonth(date2.getMonth());
                date.setDate(date2.getDate());
                this.bNF.getLiveCardData().setStartTime(date.getTime() / 1000);
                this.cfk.setText(com.baidu.tbadk.core.util.ba.o(this.bNF.getLiveCardData().getStartTime() * 1000));
            }
            if ((com.baidu.adp.lib.util.k.isEmpty(this.bOa.getText().toString()) || this.ceQ || this.ceR) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                this.bNF.setContent(writeData.getContent());
                SpannableString a = TbFaceManager.vK().a(getPageContext().getPageActivity(), this.bNF.getContent(), new bf(this));
                this.bOa.setText(a);
                this.bOa.setSelection(a.length());
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo = writeData.getWriteImagesInfo();
                this.bNF.setWriteImagesInfo(this.writeImagesInfo);
                this.bUs.a(this.writeImagesInfo, true);
                eM(false);
            }
            if (TbadkCoreApplication.m255getInst().isBaobaoShouldOpen()) {
                if (writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                    this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                    this.bNF.setIsBaobao(writeData.getIsBaobao());
                    this.bNF.setBaobaoContent(writeData.getBaobaoContent());
                    this.bNF.setBaobaoImagesInfo(this.baobaoImagesInfo);
                }
                if (this.bNF.getIsBaobao()) {
                    this.bUs.setBaobaoUris(this.baobaoImagesInfo);
                    eN(false);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.bNF.getType());
        bundle.putString("forum_id", this.bNF.getForumId());
        bundle.putString("forum_name", this.bNF.getForumName());
        bundle.putString("thread_id", this.bNF.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.bNF.getFloor());
        bundle.putInt(WriteActivityConfig.FLOOR_NUM, this.bNF.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.ceX);
        if (this.ceQ) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putSerializable(WriteActivityConfig.BAOBAO_IMAGES, this.baobaoImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aAI);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.cfd);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.cfi);
        if (this.bNF.getLiveCardData() != null) {
            bundle.putBoolean(WriteActivityConfig.IS_LIVE_POST, true);
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ID, this.bNF.getLiveCardData().getGroupId());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_HEAD, this.bNF.getLiveCardData().getPortrait());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_INTRO, this.bNF.getLiveCardData().getIntro());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_NAME, this.bNF.getLiveCardData().getName());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_MEMBER_COUNT, this.bNF.getLiveCardData().getListeners());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ZAN_COUNT, this.bNF.getLiveCardData().getLikers());
            bundle.putLong(WriteActivityConfig.LIVE_DATE, this.bNF.getLiveCardData().getStartTime());
            bundle.putBoolean(WriteActivityConfig.LIVE_TIME_IS_MODIFY, this.bNF.getLiveCardData().isModifyTime());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_PUBLISH_HEAD, this.bNF.getLiveCardData().getPublisherPortrait());
        }
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = this.bOa.getEditableText().toString();
        if (editable != null) {
            this.bOa.setText(TbFaceManager.vK().F(getPageContext().getPageActivity(), editable));
            this.bOa.setSelection(this.bOa.getText().length());
        }
    }

    public void acB() {
        acy();
        if (this.bNF.getLiveCardData() != null) {
            if (!this.bNF.getLiveCardData().isModifyTime()) {
                this.bNF.getLiveCardData().setStartTime(new Date().getTime() / 1000);
                this.cfk.setText(com.baidu.tbadk.core.util.ba.o(this.bNF.getLiveCardData().getStartTime() * 1000));
            }
            long time = new Date().getTime() / TbConfig.USE_TIME_INTERVAL;
            Date date = new Date(this.bNF.getLiveCardData().getStartTime() * 1000);
            Date date2 = new Date();
            date.setYear(date2.getYear());
            date.setMonth(date2.getMonth());
            date.setDate(date2.getDate());
            this.bNF.getLiveCardData().setStartTime(date.getTime() / 1000);
            if (time > this.bNF.getLiveCardData().getStartTime() / 60) {
                showToast(com.baidu.tieba.z.live_start_time_error);
                return;
            }
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.bNG != this.mPrefixData.getPrefixs().size() - 1) {
            this.bNF.setTitle(String.valueOf(this.bOc.getText().toString()) + this.bNW.getText().toString());
        } else {
            this.bNF.setTitle(this.bNW.getText().toString());
        }
        this.bNF.setContent(this.bOa.getText().toString());
        if (this.ceQ || this.ceR) {
            String string = getResources().getString(com.baidu.tieba.z.android_feedback);
            if (TextUtils.isEmpty(this.bNF.getTitle()) || !this.bNF.getTitle().startsWith(string)) {
                this.bNF.setTitle(string + this.bNF.getTitle());
            }
            String string2 = getResources().getString(com.baidu.tieba.z.tieba_client);
            if (TextUtils.isEmpty(this.bNF.getContent()) || !this.bNF.getContent().startsWith(string2)) {
                StringBuilder sb = new StringBuilder();
                sb.append(string2);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.i.fg()) {
                    sb.append(com.baidu.adp.lib.util.i.fn());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.bNF.getContent());
                this.bNF.setContent(sb.toString());
            }
        }
        this.bNF.setWriteImagesInfo(this.writeImagesInfo);
        this.bNF.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.bNF.setHasLocationData(this.cfa.getLocationInfoViewState() == 2);
        this.aAK.ey(this.writeImagesInfo.size() > 0);
        this.aAK.c(this.bNF);
        VoiceData.VoiceModel audioData = this.bUs.getAudioData();
        this.bUs.Fq();
        this.bNF.setVcode(null);
        if (audioData != null) {
            if (audioData.getId() != null) {
                this.aAK.EV().setVoice(audioData.getId());
                this.aAK.EV().setVoiceDuringTime(audioData.duration);
            } else {
                this.aAK.EV().setVoice(null);
                this.aAK.EV().setVoiceDuringTime(-1);
            }
        } else {
            this.aAK.EV().setVoice(null);
            this.aAK.EV().setVoiceDuringTime(-1);
        }
        if (!this.aAK.aic()) {
            showToast(com.baidu.tieba.z.write_img_limit);
        } else if (this.aAK.aib()) {
            showLoadingDialog(getPageContext().getString(com.baidu.tieba.z.sending), this.bFV);
        }
    }

    private void m(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.cfd != null) {
                i2 = this.cfd.getTotalCount();
                i = this.cfd.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(com.baidu.tieba.z.write_addition_left_count), Integer.valueOf(i2 - i)));
            }
        }
        com.baidu.adp.lib.util.l.showToast(getPageContext().getPageActivity(), sb.toString());
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        int size;
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12004) {
                ArrayList<String> T = com.baidu.tieba.tbadkCore.util.i.T(intent);
                if (T != null && T.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < T.size()) {
                            sb.append("@");
                            sb.append(T.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            this.bOa.getText().insert(this.bOa.getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                if (this.bNF.getType() == 0) {
                    com.baidu.tieba.tbadkCore.al.a(this.bNF.getForumId(), (WriteData) null);
                } else if (this.bNF.getType() == 1) {
                    com.baidu.tieba.tbadkCore.al.b(this.bNF.getThreadId(), (WriteData) null);
                }
                setResult(-1);
                finish();
            } else if (i == 12002) {
                J(intent);
                acG();
                this.bUs.setVisibility(0);
            } else if (i == 12001) {
                L(intent);
                int size2 = this.writeImagesInfo.size() - 1;
                if (size2 > -1 && this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size2)));
                }
            } else if (i == 12012) {
                K(intent);
                acG();
            } else if (i == 12013) {
                M(intent);
                acG();
            } else if (i == 23004) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    EW();
                    return;
                case 12002:
                    if (!this.bUs.afs()) {
                        akg();
                    }
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                        return;
                    }
                    return;
                case 12009:
                    com.baidu.tieba.tbadkCore.f.g.q(getPageContext().getPageActivity());
                    return;
                case 12010:
                    this.aAI = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.aw.a(getPageContext(), this.aAI);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.bNW);
        HidenSoftKeyPad(this.mInputManager, this.bOa);
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void J(Intent intent) {
        b(intent, true);
    }

    private void L(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aAI;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cd = com.baidu.tbadk.core.util.d.cd(str);
                if (cd != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.d.b(str, com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.M(getPageContext().getPageActivity())), com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.N(getPageContext().getPageActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.d.h(b, cd);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.aAI, h, 100);
                    h.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            this.bUs.a(this.writeImagesInfo, true);
        }
        eM(true);
    }

    private void K(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    this.bUs.a(this.writeImagesInfo, z);
                }
            }
            eM(true);
        }
    }

    private void M(Intent intent) {
        if (this.bNF != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(stringExtra);
            this.baobaoImagesInfo.clear();
            this.baobaoImagesInfo.addChooseFile(imageFileInfo);
            this.bNF.setIsBaobao(true);
            this.bNF.setBaobaoContent(stringExtra2);
            this.bUs.setBaobaoUris(this.baobaoImagesInfo);
            eN(true);
        }
    }

    private void EW() {
        new bg(this).execute(new Void[0]);
    }

    private void eM(boolean z) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() > 0) {
            this.cfb.ee(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            this.cfc = true;
            this.bUs.ee(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            if (this.bUs.afj() || z) {
                this.bUs.afp();
                return;
            }
            return;
        }
        this.cfb.vg();
        this.cfc = false;
        this.bUs.vg();
        if (this.bUs.afu()) {
            this.cfb.afN();
            this.bUs.vo();
        }
        akg();
    }

    private void eN(boolean z) {
        LinkedList<ImageFileInfo> chosedFiles = this.baobaoImagesInfo.getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() > 0) {
            this.cfb.agd();
            this.cfb.eg("1");
            if (this.bUs.afj() || z) {
                this.bUs.afr();
            }
            this.bNF.setIsBaobao(true);
            return;
        }
        this.cfb.vn();
        this.bNF.setIsBaobao(false);
        this.cfb.agc();
        akg();
    }

    @Override // com.baidu.tbadk.core.voice.o
    public synchronized VoiceManager getVoiceManager() {
        if (this.mVoiceManager == null) {
            this.mVoiceManager = VoiceManager.instance();
        }
        return this.mVoiceManager;
    }

    @Override // com.baidu.tbadk.core.voice.o
    public com.baidu.tbadk.core.voice.m getRealView(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public synchronized void stopVoice() {
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.stopPlay();
    }

    public void a(boolean z, AntiData antiData, com.baidu.tieba.tbadkCore.f.f fVar) {
        String str = "";
        if (fVar != null) {
            str = fVar.getErrorString();
        }
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.bNF.getForumName());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.WRITE);
        } else if (this.cfd == null) {
            com.baidu.tieba.tbadkCore.f.g.d(getPageContext().getPageActivity(), fVar.getErrorString(), fVar.aie(), fVar.aif());
        } else {
            m(z, str);
        }
    }

    public void a(boolean z, AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.bNF.getForumName());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.WRITE);
        } else if (this.cfd == null) {
            com.baidu.tieba.tbadkCore.f.g.N(getPageContext().getPageActivity(), str);
        } else {
            m(z, str);
        }
    }

    @Override // com.baidu.tieba.write.ci
    public void hs(int i) {
        this.bNG = i;
        this.bOd.setCurrentIndex(i);
        this.bOc.setText(this.mPrefixData.getPrefixs().get(i));
        acG();
        com.baidu.adp.lib.g.k.a(this.bOd, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.bOf.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
