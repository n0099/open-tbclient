package com.baidu.tieba.write;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
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
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
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
    private com.baidu.tieba.tbadkCore.location.d aBF;
    private String aBK;
    private com.baidu.tieba.tbadkCore.f.a aBM;
    private View bPI;
    private TextView bPM;
    private ch bPN;
    private ImageView bPO;
    private View bPP;
    private int bPq;
    private AdditionData cgB;
    private RelativeLayout cgC;
    private TextView cgD;
    private TextView cgE;
    private TextView cgF;
    private RelativeLayout cgH;
    private TextView cgI;
    private View cgJ;
    private LiveBroadcastCard cgK;
    private com.baidu.tieba.view.g cgR;
    private Toast cgy;
    private GestureDetector mGestureDetector;
    private PostPrefixData mPrefixData;
    private VoiceManager mVoiceManager;
    private WriteData bPp = null;
    private boolean cgp = false;
    private boolean cgq = false;
    private InputMethodManager mInputManager = null;
    private EditText bPG = null;
    private View bPH = null;
    private LinearLayout bPJ = null;
    private EditText bPK = null;
    private o cgr = null;
    private FeedBackTopListView cgs = null;
    private String bVb = null;
    private final KeyEvent cgt = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView cgu = null;
    private TextView bPL = null;
    private TextView aAq = null;
    private DialogInterface.OnCancelListener bHG = null;
    private com.baidu.tbadk.core.dialog.a cgv = null;
    private final Handler mHandler = new Handler();
    private boolean cgw = false;
    private String cgx = null;
    private RelativeLayout mParent = null;
    private String bAr = null;
    private com.baidu.tieba.tbadkCore.PbEditor.k cgz = null;
    private TbEditorToolButtonContainer cgA = null;
    private EditorToolComponetContainer bWk = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private int cgG = 0;
    private HttpMessageListener cgL = new ac(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private final com.baidu.tieba.tbadkCore.f.c aDC = new an(this);
    private com.baidu.tieba.tbadkCore.location.i aBQ = new az(this);
    private View.OnClickListener cgM = new bh(this);
    private CustomMessageListener cas = new bi(this, 2001232);
    private final Runnable cgN = new bj(this);
    private final View.OnClickListener cgO = new bk(this);
    private boolean cgP = true;
    private final View.OnFocusChangeListener bPE = new bl(this);
    private final CustomMessageListener cgQ = new bm(this, 2001310);
    private com.baidu.tieba.tbadkCore.bubble.y aGh = new ad(this);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(WriteActivityConfig.class, WriteActivity.class);
        com.baidu.tieba.tbadkCore.location.d.aii();
    }

    public void Fp() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Fq() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(com.baidu.tieba.z.location_system_permission_prompt);
            this.cgz.setLocationInfoViewState(0);
        } else if (!TbadkCoreApplication.m255getInst().getLocationShared()) {
            Fr();
        } else if (this.aBF.aih()) {
            Fp();
        } else {
            this.aBF.eE(false);
            this.cgz.setLocationInfoViewState(1);
            this.aBF.aif();
        }
    }

    private void Fr() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.by(com.baidu.tieba.z.location_app_permission_prompt).a(com.baidu.tieba.z.isopen, new ae(this)).b(com.baidu.tieba.z.cancel, new af(this)).b(getPageContext());
        aVar.nX();
    }

    public int aku() {
        int selectionEnd = this.bPK.getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) this.bPK.getText().getSpans(0, this.bPK.getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = this.bPK.getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = this.bPK.getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    public void akv() {
        if (!this.cgP) {
            this.cgA.afu();
        } else {
            this.cgA.afv();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        this.bWk.agc();
        if (this.cgR != null && this.bPp != null && this.bPp.getLiveCardData() != null) {
            new Handler().postDelayed(new ag(this, new Date(this.bPp.getLiveCardData().getStartTime() * 1000)), 100L);
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
        this.bWk.aga();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BdLog.addLogPackage(WriteActivity.class.getPackage().getName());
        super.onCreate(bundle);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new bn(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        initUI();
        akA();
        MessageManager.getInstance().unRegisterListener(getUniqueId());
        this.cgQ.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.cgQ);
        this.aBF = new com.baidu.tieba.tbadkCore.location.d(this);
        this.aBF.a(this.aBQ);
        registerListener(this.cas);
        if (this.cgB == null) {
            Fs();
        }
        this.bPK.requestFocus();
    }

    public void ajh() {
        boolean appResponseToCmd = TbadkCoreApplication.m255getInst().appResponseToCmd(2802001);
        if (!TbadkCoreApplication.m255getInst().isBaobaoShouldOpen() || this.cgB != null || !appResponseToCmd) {
            this.cgA.agL();
        }
    }

    private void Fs() {
        if (this.aBF.aij()) {
            if (this.aBF.aih()) {
                this.cgz.B(2, com.baidu.tieba.tbadkCore.location.c.aic().getLocationData().ahY());
                return;
            }
            this.cgz.setLocationInfoViewState(1);
            this.aBF.aif();
            return;
        }
        this.cgz.setLocationInfoViewState(0);
    }

    public void adc() {
        if (this.aBM != null) {
            this.aBM.cancelLoadData();
        }
        if (this.cgr != null) {
            this.cgr.cancelLoadData();
        }
        if (this.aBF != null) {
            this.aBF.cancelLoadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        adc();
        akJ();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
    }

    public void akw() {
        if (this.bPp != null && this.bPp.getType() == 2 && this.cgw) {
            finish();
        } else if (this.bPp == null) {
            finish();
        } else {
            this.bPp.setTitle(this.bPG.getText().toString());
            this.bPp.setContent(this.bPK.getText().toString());
            int type = this.bPp.getType();
            if (this.bPp.getHaveDraft() && com.baidu.adp.lib.util.k.isEmpty(this.bPp.getTitle()) && com.baidu.adp.lib.util.k.isEmpty(this.bPp.getContent()) && !this.bPp.isHasImages()) {
                if (type == 0) {
                    if (this.bPp.getLiveCardData() == null) {
                        com.baidu.tieba.tbadkCore.al.a(this.bPp.getForumId(), (WriteData) null);
                    } else {
                        com.baidu.tieba.tbadkCore.al.a(this.bPp.getLiveCardData().getGroupId(), (WriteData) null);
                    }
                } else if (type == 1) {
                    com.baidu.tieba.tbadkCore.al.b(this.bPp.getThreadId(), (WriteData) null);
                }
            } else if (type == 0) {
                if (this.bPp.getLiveCardData() == null) {
                    com.baidu.tieba.tbadkCore.al.a(this.bPp.getForumId(), this.bPp);
                } else {
                    com.baidu.tieba.tbadkCore.al.a(this.bPp.getLiveCardData().getGroupId(), this.bPp);
                }
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.al.b(this.bPp.getThreadId(), this.bPp);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bPN != null && this.bPN.isShowing()) {
                com.baidu.adp.lib.g.k.a(this.bPN, getPageContext().getPageActivity());
                return true;
            } else if (this.bWk.afN()) {
                this.cgA.afw();
                this.bWk.hideAll();
                return true;
            } else {
                adc();
                akw();
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
        com.baidu.tbadk.core.util.bc.g(this.bPL, i);
        akv();
        com.baidu.tbadk.core.util.bc.j(this.bPH, com.baidu.tieba.t.cp_bg_line_c);
        com.baidu.tbadk.core.util.bc.j(this.bPI, com.baidu.tieba.t.cp_bg_line_c);
        com.baidu.tbadk.core.util.bc.j((View) this.bPG, com.baidu.tieba.t.cp_bg_line_d);
        if (TextUtils.isEmpty(this.bVb)) {
            com.baidu.tbadk.core.util.bc.j((View) this.bPK, com.baidu.tieba.t.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.bc.getColor(com.baidu.tieba.t.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.bc.getColor(com.baidu.tieba.t.cp_cont_e);
        this.cgA.changeSkinType(i);
        this.bPG.setTextColor(color);
        this.bPK.setTextColor(color);
        a(this.bPG, color2);
        a(this.bPK, color2);
        adk();
        this.bWk.onChangeSkinType(i);
        this.cgz.wu();
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
        this.aAq = this.mNavigationBar.setTitleText("");
        this.cgu = (TextView) findViewById(com.baidu.tieba.w.btn_image_problem);
        this.bPL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(com.baidu.tieba.z.send_post));
        this.bPL.setOnFocusChangeListener(this.bPE);
        addGlobalLayoutListener();
        this.cgs = (FeedBackTopListView) findViewById(com.baidu.tieba.w.feedback_top_list);
        this.mParent = (RelativeLayout) findViewById(com.baidu.tieba.w.parent);
        this.bPH = findViewById(com.baidu.tieba.w.interval_view);
        this.bPI = findViewById(com.baidu.tieba.w.prefix_interval_view);
        adj();
        this.mHandler.postDelayed(this.cgN, 200L);
        adl();
        if (this.cgp || this.cgq) {
            getWindow().setSoftInputMode(18);
            if (CDNIPDirectConnect.pX().hasImageProblem()) {
                findViewById(com.baidu.tieba.w.ll_image_problem).setVisibility(0);
            } else {
                findViewById(com.baidu.tieba.w.ll_image_problem).setVisibility(8);
            }
        }
        this.bPJ = (LinearLayout) findViewById(com.baidu.tieba.w.post_content_container);
        this.bPJ.setDrawingCacheEnabled(false);
        this.bPJ.setOnClickListener(new ah(this));
        this.mBack.setOnFocusChangeListener(this.bPE);
        this.mBack.setOnClickListener(new ai(this));
        this.cgu.setOnClickListener(new aj(this));
        this.cgz = new com.baidu.tieba.tbadkCore.PbEditor.k((EditorInfoContainer) findViewById(com.baidu.tieba.w.write_editor_info));
        this.cgz.H(this.cgM);
        if (this.cgB != null) {
            this.cgz.destroy();
        }
        akG();
        akD();
        akB();
        ajh();
        if (this.bPp.getType() == 0) {
            if (this.cgp || this.cgq) {
                this.cgA.agL();
                this.aAq.setText(com.baidu.tieba.z.feedback);
            } else {
                this.aAq.setText(com.baidu.tieba.z.post_new_thread);
            }
            this.bPG.setVisibility(0);
            this.bPK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
        } else {
            this.aAq.setText(com.baidu.tieba.z.send_reply);
            this.bPK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
            this.bPG.setVisibility(8);
        }
        akC();
        akI();
        g(akK());
        akv();
        akz();
        adi();
        aky();
        adk();
        if (this.bPp.getLiveCardData() == null) {
            ShowSoftKeyPad(this.mInputManager, this.bPG);
        }
        akx();
    }

    private void akx() {
        if (this.bWk != null) {
            int skinType = TbadkCoreApplication.m255getInst().getSkinType();
            this.bWk.setShadowHeight(getResources().getDimensionPixelSize(com.baidu.tieba.u.ds1));
            if (skinType == 1) {
                this.bWk.setShadowBackground(com.baidu.tieba.t.cp_bg_line_b_1);
            } else {
                this.bWk.setShadowBackground(com.baidu.tieba.t.cp_cont_e);
            }
        }
    }

    private void aky() {
        this.cgH = (RelativeLayout) findViewById(com.baidu.tieba.w.live_time_rel);
        this.cgI = (TextView) findViewById(com.baidu.tieba.w.live_tiem_show);
        this.cgJ = findViewById(com.baidu.tieba.w.interval_view2);
        this.cgK = (LiveBroadcastCard) findViewById(com.baidu.tieba.w.live_anchor_card);
        this.cgH.setOnClickListener(new ak(this));
        this.cgH.setOnTouchListener(new al(this));
        if (this.bPp.getLiveCardData() != null) {
            this.cgH.setVisibility(0);
            this.cgJ.setVisibility(0);
            this.cgK.setVisibility(0);
            this.cgK.setClickable(false);
            this.cgI.setText(com.baidu.tbadk.core.util.bf.o(this.bPp.getLiveCardData().getStartTime() * 1000));
            this.cgK.setData(this.bPp.getLiveCardData());
            return;
        }
        this.cgH.setVisibility(8);
        this.cgJ.setVisibility(8);
        this.cgK.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if ((dialog instanceof com.baidu.tieba.view.g) && this.bPp.getLiveCardData() != null) {
            Date date = new Date(this.bPp.getLiveCardData().getStartTime() * 1000);
            ((com.baidu.tieba.view.g) dialog).updateTime(date.getHours(), date.getMinutes());
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.cgR = new com.baidu.tieba.view.g(getPageContext().getPageActivity(), new am(this), new Date().getHours(), new Date().getMinutes(), false);
        this.cgR.setTitle(com.baidu.tieba.z.no_disturb_start_time);
        this.cgR.setButton(-1, getPageContext().getString(com.baidu.tieba.z.alert_yes_button), this.cgR);
        this.cgR.setButton(-2, getPageContext().getString(com.baidu.tieba.z.alert_no_button), this.cgR);
        return this.cgR;
    }

    private void akz() {
        this.cgC = (RelativeLayout) findViewById(com.baidu.tieba.w.addition_container);
        this.cgD = (TextView) findViewById(com.baidu.tieba.w.addition_create_time);
        this.cgE = (TextView) findViewById(com.baidu.tieba.w.addition_last_time);
        this.cgF = (TextView) findViewById(com.baidu.tieba.w.addition_last_content);
        if (this.cgB != null) {
            this.cgC.setVisibility(0);
            this.cgD.setText(String.valueOf(getPageContext().getString(com.baidu.tieba.z.write_addition_create)) + com.baidu.tbadk.core.util.bf.n(this.cgB.getCreateTime() * 1000));
            if (this.cgB.getAlreadyCount() == 0) {
                this.cgE.setVisibility(8);
            } else {
                this.cgE.setText(String.valueOf(getPageContext().getString(com.baidu.tieba.z.write_addition_last)) + com.baidu.tbadk.core.util.bf.n(this.cgB.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.cgB.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.cgF.setText(lastAdditionContent);
            } else {
                this.cgF.setVisibility(8);
            }
            this.bPK.setHint(String.format(getPageContext().getString(com.baidu.tieba.z.write_addition_hint), Integer.valueOf(this.cgB.getAlreadyCount()), Integer.valueOf(this.cgB.getTotalCount())));
            this.aAq.setText(com.baidu.tieba.z.write_addition_title);
            return;
        }
        this.cgC.setVisibility(8);
    }

    private void adi() {
        this.bPP = findViewById(com.baidu.tieba.w.post_prefix_layout);
        this.bPM = (TextView) findViewById(com.baidu.tieba.w.post_prefix);
        this.bPO = (ImageView) findViewById(com.baidu.tieba.w.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.bPP.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.bPM.setText(prefixs.get(0));
            this.bPq = 0;
            this.bPP.setOnClickListener(new ao(this));
            this.bPO = (ImageView) findViewById(com.baidu.tieba.w.prefix_icon);
            if (size > 1) {
                this.bPO.setVisibility(0);
                this.bPM.setOnClickListener(new ap(this));
            }
            this.bPN = new ch(getPageContext().getPageActivity());
            this.bPN.a(this);
            this.bPN.setMaxHeight(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 225.0f));
            this.bPN.setOutsideTouchable(true);
            this.bPN.setFocusable(true);
            this.bPN.setOnDismissListener(this);
            this.bPN.setBackgroundDrawable(com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.t.cp_bg_line_b));
            int color = com.baidu.tbadk.core.util.bc.getColor(com.baidu.tieba.t.write_text);
            com.baidu.tbadk.core.util.bc.i((View) this.bPM, com.baidu.tieba.v.write_prefix_item_selector);
            com.baidu.tbadk.core.util.bc.c(this.bPO, com.baidu.tieba.v.icon_title_down);
            this.bPM.setTextColor(color);
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
                com.baidu.tbadk.core.util.bc.i((View) textView, com.baidu.tieba.v.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), getResources().getDimension(com.baidu.tieba.u.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), getResources().getDimension(com.baidu.tieba.u.ds22)), 0);
                this.bPN.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), getResources().getDimension(com.baidu.tieba.u.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), getResources().getDimension(com.baidu.tieba.u.ds22)), 0);
                }
            }
            this.bPN.setCurrentIndex(0);
            return;
        }
        this.bPP.setVisibility(8);
    }

    private void akA() {
        if (this.cgp && this.bPp != null) {
            this.cgs.setVisibility(0);
            this.cgr = new o(this);
            this.cgr.iD(this.bPp.getForumName());
            this.cgr.setLoadDataCallBack(new aq(this));
        }
    }

    protected void akB() {
        this.bPL.setOnClickListener(new ar(this));
    }

    protected void akC() {
        this.cgv = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.cgv.bW(getPageContext().getString(com.baidu.tieba.z.is_save_draft)).ah(false).a(getPageContext().getString(com.baidu.tieba.z.save), new as(this)).b(getPageContext().getString(com.baidu.tieba.z.not_save), new au(this));
        this.cgv.b(getPageContext());
    }

    protected void adj() {
        this.bPG = (EditText) findViewById(com.baidu.tieba.w.post_title);
        this.bPG.setOnClickListener(this.cgO);
        this.bPG.setOnFocusChangeListener(this.bPE);
        if (this.bPp.getType() == 0) {
            if (this.bPp.getTitle() != null) {
                this.bPG.setText(this.bPp.getTitle());
                this.bPG.setSelection(this.bPp.getTitle().length());
            }
        } else if (this.bPp.getType() != 1) {
            this.bPp.getType();
        }
        this.bPG.addTextChangedListener(new av(this));
    }

    protected void adl() {
        this.bPK = (EditText) findViewById(com.baidu.tieba.w.post_content);
        this.bPK.setDrawingCacheEnabled(false);
        this.bPK.setOnClickListener(this.cgO);
        if (this.bPp.getContent() != null && this.bPp.getContent().length() > 0) {
            SpannableString E = TbFaceManager.wd().E(getPageContext().getPageActivity(), this.bPp.getContent());
            this.bPK.setText(E);
            this.bPK.setSelection(E.length());
        } else if (this.bPp.getType() == 2) {
            if (this.cgw) {
                if (this.cgx != null && this.cgx.length() > 0) {
                    this.bPK.setText(getPageContext().getPageActivity().getString(com.baidu.tieba.z.reply_sub_floor, new Object[]{this.cgx}));
                    this.bPK.setSelection(this.bPK.getText().length());
                }
            } else if (this.bPp.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(com.baidu.tieba.z.reply_x_floor), Integer.valueOf(this.bPp.getFloorNum()));
                this.bPK.setText(format);
                this.bPK.setSelection(format.length());
            }
        }
        this.bPK.setOnFocusChangeListener(this.bPE);
        this.bPK.setOnTouchListener(new aw(this));
        this.bPK.addTextChangedListener(new ax(this));
        eQ(true);
    }

    public void eQ(boolean z) {
        if (TbadkCoreApplication.m255getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class)) {
            this.bPK.setPadding(0, 0, 0, 0);
            this.bPK.setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.bc.j((View) this.bPK, com.baidu.tieba.t.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.bVb) && this.cgB == null) {
                com.baidu.adp.lib.f.d.ec().a(this.bVb, 19, new ay(this, z), getUniqueId());
            }
        }
    }

    public boolean FJ() {
        int i = 5000;
        if (this.cgB != null) {
            i = 1000;
        }
        return this.bPK.getText() != null && this.bPK.getText().length() >= i;
    }

    protected void akD() {
        this.bWk = (EditorToolComponetContainer) findViewById(com.baidu.tieba.w.tool_group);
        this.bWk.setFrom(1);
        Boolean akK = akK();
        if (this.cgp || (akK != null && !akK.booleanValue())) {
            this.bWk.vJ();
        } else {
            this.bWk.vI();
        }
        this.bWk.setOnActionListener(new ba(this));
        this.bWk.refresh();
    }

    protected void akE() {
        this.cgA.afw();
        if (this.bWk.afN()) {
            this.bWk.hideAll();
        }
    }

    public void akF() {
        this.bWk.X(this.bPK);
    }

    public void it(int i) {
        if (this.bWk.afN()) {
            iu(i);
            return;
        }
        this.bWk.W(this.bPG);
        this.bWk.W(this.bPK);
        new Handler().postDelayed(new bb(this, i), 200L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
        if (this.bWk != null) {
            this.bWk.afP();
        }
    }

    public void iu(int i) {
        if (i == 2) {
            this.cgA.agE();
            this.bWk.afR();
        } else if (i == 5 || i == 60) {
            this.bWk.afS();
        } else if (i == 8) {
            this.bWk.afT();
            this.cgA.agF();
        } else if (i == 50) {
            this.bWk.afV();
            this.cgA.agI();
        } else if (i == 44) {
            this.bWk.afU();
            this.cgA.agG();
        } else if (i == 38) {
            this.bWk.afQ();
            this.cgA.agJ();
        } else if (i == 57) {
            this.bWk.afT();
            this.cgA.agF();
        } else if (i == 48) {
            this.bWk.afV();
        }
    }

    protected void akG() {
        this.cgA = (TbEditorToolButtonContainer) findViewById(com.baidu.tieba.w.write_eidtor_tool_buttons);
        this.cgA.afv();
        this.cgA.setAtFocusable(false);
        this.cgA.setOnActionListener(new bc(this));
        if (TbadkCoreApplication.m255getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.cgA.ez(false);
        }
    }

    public void iv(int i) {
        if (this.bWk.afX()) {
            it(i);
        } else if (!com.baidu.tieba.tbadkCore.PbEditor.a.afl() && this.cgG == 0) {
            showToast(com.baidu.tieba.z.baobao_over_limit);
        } else {
            String charSequence = this.aAq.getText().toString();
            com.baidu.tbadk.core.frameworkData.a aVar = new com.baidu.tbadk.core.frameworkData.a(getPageContext().getPageActivity());
            aVar.getIntent().putExtra("title", charSequence);
            aVar.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
            sendMessage(new CustomMessage(2802001, aVar));
        }
    }

    public void a(com.baidu.tbadk.coreExtra.data.f fVar) {
        if (((ImageSpan[]) this.bPK.getText().getSpans(0, this.bPK.getText().length(), ImageSpan.class)).length >= 10) {
            if (this.cgy == null) {
                this.cgy = Toast.makeText(getPageContext().getPageActivity(), com.baidu.tieba.z.too_many_face, 0);
            }
            this.cgy.show();
            return;
        }
        String name = fVar.getName();
        EmotionGroupType rM = fVar.rM();
        if (name != null) {
            com.baidu.adp.lib.f.d.ec().a(name, 20, new bd(this, new SpannableStringBuilder(name), this.bPK.getSelectionStart(), rM), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        Bitmap jj = aVar.jj();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(jj);
        int width = jj.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            width = (int) (0.5d * width);
        }
        bitmapDrawable.setBounds(0, 0, width + 1, width);
        bitmapDrawable.setGravity(119);
        spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
        this.bPK.getText().insert(i, spannableStringBuilder);
    }

    public void akH() {
        this.bPK.onKeyDown(67, this.cgt);
    }

    private void g(Boolean bool) {
    }

    private void akI() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void akJ() {
        try {
            if (this.cgv != null) {
                this.cgv.dismiss();
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

    private Boolean akK() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.bAr = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void adk() {
        String str = null;
        if (this.bPp.getType() == 0) {
            String trim = this.bPG.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.bPq == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.bPp.setIsNoTitle(true);
                    } else {
                        this.bPp.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.bPp.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.bPp.setIsNoTitle(true);
            } else {
                this.bPp.setIsNoTitle(false);
                str = "1";
            }
        }
        String trim2 = this.bPK.getText().toString().trim();
        if (this.bWk.afW()) {
            str = "1";
        } else if (!TextUtils.isEmpty(trim2)) {
            str = "1";
        } else if (this.bWk.afY()) {
            str = "1";
        } else if (this.bWk.afX()) {
            str = "1";
        }
        if (str == null || str.length() <= 0) {
            this.bPL.setEnabled(false);
        } else {
            this.bPL.setEnabled(true);
        }
    }

    private void initData(Bundle bundle) {
        this.aBM = new com.baidu.tieba.tbadkCore.f.a(this);
        this.aBM.a(this.aDC);
        registerListener(this.cgL);
        this.bHG = new be(this);
        this.bPp = new WriteData();
        if (bundle != null) {
            this.bPp.setType(bundle.getInt("type", 0));
            this.bPp.setForumId(bundle.getString("forum_id"));
            this.bPp.setForumName(bundle.getString("forum_name"));
            this.bPp.setThreadId(bundle.getString("thread_id"));
            this.bPp.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.bPp.setFloorNum(bundle.getInt(WriteActivityConfig.FLOOR_NUM, 0));
            this.cgp = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.cgw = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.cgx = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.baobaoImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.BAOBAO_IMAGES);
            this.aBK = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.cgB = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.bPp.setIsAddition(this.cgB != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.cgG = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
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
                this.bPp.setLiveCardData(liveCardData);
            }
        } else {
            Intent intent = getIntent();
            this.bPp.setType(intent.getIntExtra("type", 0));
            this.bPp.setForumId(intent.getStringExtra("forum_id"));
            this.bPp.setForumName(intent.getStringExtra("forum_name"));
            this.bPp.setThreadId(intent.getStringExtra("thread_id"));
            this.bPp.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.bPp.setFloorNum(intent.getIntExtra(WriteActivityConfig.FLOOR_NUM, 0));
            this.cgp = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.cgw = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.cgx = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.cgB = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.bPp.setIsAddition(this.cgB != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.cgG = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
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
                this.bPp.setLiveCardData(liveCardData2);
            }
        }
        this.baobaoImagesInfo.setMaxImagesAllowed(1);
        this.writeImagesInfo.setMaxImagesAllowed(10);
        this.bPp.setWriteImagesInfo(this.writeImagesInfo);
        this.bPp.setBaobaoImagesInfo(this.baobaoImagesInfo);
        if (this.bPp.getType() == 0) {
            if (this.bPp.getLiveCardData() == null) {
                com.baidu.tieba.tbadkCore.al.b(this.bPp.getForumId(), this);
            } else {
                com.baidu.tieba.tbadkCore.al.a(this.bPp.getLiveCardData().getGroupId(), this);
            }
        } else if (this.bPp.getType() == 1) {
            com.baidu.tieba.tbadkCore.al.a(this.bPp.getThreadId(), this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(com.baidu.tieba.z.write_no_prefix));
        }
        this.bVb = TbadkCoreApplication.m255getInst().getDefaultBubble();
        if (this.bPp != null && this.bPp.getForumName() != null && TbadkCoreApplication.m255getInst().getYijianfankuiFname() != null && this.bPp.getForumName().equals(TbadkCoreApplication.m255getInst().getYijianfankuiFname())) {
            this.cgq = true;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.am
    public void a(WriteData writeData) {
        if (writeData != null && this.bPp != null) {
            this.bPp.setHaveDraft(true);
            if (com.baidu.adp.lib.util.k.isEmpty(this.bPG.getText().toString()) || ((this.cgp || this.cgq) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                this.bPp.setTitle(writeData.getTitle());
                this.bPG.setText(this.bPp.getTitle());
                this.bPG.setSelection(this.bPp.getTitle().length());
            }
            if (writeData.getLiveCardData() != null) {
                Date date = new Date(writeData.getLiveCardData().getStartTime() * 1000);
                Date date2 = new Date();
                date.setYear(date2.getYear());
                date.setMonth(date2.getMonth());
                date.setDate(date2.getDate());
                this.bPp.getLiveCardData().setStartTime(date.getTime() / 1000);
                this.cgI.setText(com.baidu.tbadk.core.util.bf.o(this.bPp.getLiveCardData().getStartTime() * 1000));
            }
            if ((com.baidu.adp.lib.util.k.isEmpty(this.bPK.getText().toString()) || this.cgp || this.cgq) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                this.bPp.setContent(writeData.getContent());
                SpannableString a = TbFaceManager.wd().a(getPageContext().getPageActivity(), this.bPp.getContent(), new bf(this));
                this.bPK.setText(a);
                this.bPK.setSelection(a.length());
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo = writeData.getWriteImagesInfo();
                this.bPp.setWriteImagesInfo(this.writeImagesInfo);
                this.bWk.a(this.writeImagesInfo, true);
                eR(false);
            }
            if (TbadkCoreApplication.m255getInst().isBaobaoShouldOpen()) {
                if (writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                    this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                    this.bPp.setIsBaobao(writeData.getIsBaobao());
                    this.bPp.setBaobaoContent(writeData.getBaobaoContent());
                    this.bPp.setBaobaoImagesInfo(this.baobaoImagesInfo);
                }
                if (this.bPp.getIsBaobao()) {
                    this.bWk.setBaobaoUris(this.baobaoImagesInfo);
                    eS(false);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.bPp.getType());
        bundle.putString("forum_id", this.bPp.getForumId());
        bundle.putString("forum_name", this.bPp.getForumName());
        bundle.putString("thread_id", this.bPp.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.bPp.getFloor());
        bundle.putInt(WriteActivityConfig.FLOOR_NUM, this.bPp.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.cgw);
        if (this.cgp) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putSerializable(WriteActivityConfig.BAOBAO_IMAGES, this.baobaoImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aBK);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.cgB);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.cgG);
        if (this.bPp.getLiveCardData() != null) {
            bundle.putBoolean(WriteActivityConfig.IS_LIVE_POST, true);
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ID, this.bPp.getLiveCardData().getGroupId());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_HEAD, this.bPp.getLiveCardData().getPortrait());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_INTRO, this.bPp.getLiveCardData().getIntro());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_NAME, this.bPp.getLiveCardData().getName());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_MEMBER_COUNT, this.bPp.getLiveCardData().getListeners());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ZAN_COUNT, this.bPp.getLiveCardData().getLikers());
            bundle.putLong(WriteActivityConfig.LIVE_DATE, this.bPp.getLiveCardData().getStartTime());
            bundle.putBoolean(WriteActivityConfig.LIVE_TIME_IS_MODIFY, this.bPp.getLiveCardData().isModifyTime());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_PUBLISH_HEAD, this.bPp.getLiveCardData().getPublisherPortrait());
        }
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = this.bPK.getEditableText().toString();
        if (editable != null) {
            this.bPK.setText(TbFaceManager.wd().E(getPageContext().getPageActivity(), editable));
            this.bPK.setSelection(this.bPK.getText().length());
        }
    }

    public void adf() {
        adc();
        if (this.bPp.getLiveCardData() != null) {
            if (!this.bPp.getLiveCardData().isModifyTime()) {
                this.bPp.getLiveCardData().setStartTime(new Date().getTime() / 1000);
                this.cgI.setText(com.baidu.tbadk.core.util.bf.o(this.bPp.getLiveCardData().getStartTime() * 1000));
            }
            long time = new Date().getTime() / TbConfig.USE_TIME_INTERVAL;
            Date date = new Date(this.bPp.getLiveCardData().getStartTime() * 1000);
            Date date2 = new Date();
            date.setYear(date2.getYear());
            date.setMonth(date2.getMonth());
            date.setDate(date2.getDate());
            this.bPp.getLiveCardData().setStartTime(date.getTime() / 1000);
            if (time > this.bPp.getLiveCardData().getStartTime() / 60) {
                showToast(com.baidu.tieba.z.live_start_time_error);
                return;
            }
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.bPq != this.mPrefixData.getPrefixs().size() - 1) {
            this.bPp.setTitle(String.valueOf(this.bPM.getText().toString()) + this.bPG.getText().toString());
        } else {
            this.bPp.setTitle(this.bPG.getText().toString());
        }
        this.bPp.setContent(this.bPK.getText().toString());
        if (this.cgp || this.cgq) {
            String string = getResources().getString(com.baidu.tieba.z.android_feedback);
            if (TextUtils.isEmpty(this.bPp.getTitle()) || !this.bPp.getTitle().startsWith(string)) {
                this.bPp.setTitle(string + this.bPp.getTitle());
            }
            String str = String.valueOf(getResources().getString(com.baidu.tieba.z.app_name)) + getResources().getString(com.baidu.tieba.z.tieba_client);
            if (TextUtils.isEmpty(this.bPp.getContent()) || !this.bPp.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.i.ff()) {
                    sb.append(com.baidu.adp.lib.util.i.fm());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.bPp.getContent());
                this.bPp.setContent(sb.toString());
            }
        }
        this.bPp.setWriteImagesInfo(this.writeImagesInfo);
        this.bPp.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.bPp.setHasLocationData(this.cgz.getLocationInfoViewState() == 2);
        this.aBM.eF(this.writeImagesInfo.size() > 0);
        this.aBM.c(this.bPp);
        VoiceData.VoiceModel audioData = this.bWk.getAudioData();
        this.bWk.FO();
        this.bPp.setVcode(null);
        if (audioData != null) {
            if (audioData.getId() != null) {
                this.aBM.Ft().setVoice(audioData.getId());
                this.aBM.Ft().setVoiceDuringTime(audioData.duration);
            } else {
                this.aBM.Ft().setVoice(null);
                this.aBM.Ft().setVoiceDuringTime(-1);
            }
        } else {
            this.aBM.Ft().setVoice(null);
            this.aBM.Ft().setVoiceDuringTime(-1);
        }
        if (!this.aBM.aiG()) {
            showToast(com.baidu.tieba.z.write_img_limit);
        } else if (this.aBM.aiF()) {
            showLoadingDialog(getPageContext().getString(com.baidu.tieba.z.sending), this.bHG);
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
            if (this.cgB != null) {
                i2 = this.cgB.getTotalCount();
                i = this.cgB.getAlreadyCount() + 1;
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
                ArrayList<String> W = com.baidu.tieba.tbadkCore.util.i.W(intent);
                if (W != null && W.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < W.size()) {
                            sb.append("@");
                            sb.append(W.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            this.bPK.getText().insert(this.bPK.getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                if (this.bPp.getType() == 0) {
                    com.baidu.tieba.tbadkCore.al.a(this.bPp.getForumId(), (WriteData) null);
                } else if (this.bPp.getType() == 1) {
                    com.baidu.tieba.tbadkCore.al.b(this.bPp.getThreadId(), (WriteData) null);
                }
                setResult(-1);
                finish();
            } else if (i == 12002) {
                if (intent != null) {
                    if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                        Z(intent);
                    } else {
                        aa(intent);
                    }
                }
            } else if (i == 12001) {
                M(intent);
                int size2 = this.writeImagesInfo.size() - 1;
                if (size2 > -1 && this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size2)));
                }
            } else if (i == 12012) {
                L(intent);
                adk();
            } else if (i == 12013) {
                N(intent);
                adk();
            } else if (i == 23004) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    Fu();
                    return;
                case 12002:
                    if (!this.bWk.afW()) {
                        akE();
                    }
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                        return;
                    }
                    return;
                case 12010:
                    this.aBK = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.bb.a(getPageContext(), this.aBK);
                    return;
                default:
                    return;
            }
        }
    }

    public void akL() {
        if (this.writeImagesInfo != null && !TextUtils.isEmpty(this.writeImagesInfo.toJsonString())) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), String.valueOf(System.currentTimeMillis()));
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.bPG);
        HidenSoftKeyPad(this.mInputManager, this.bPK);
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void S(Intent intent) {
        b(intent, true);
    }

    public boolean akM() {
        boolean afY = this.bWk.afY();
        LinkedList<ImageFileInfo> chosedFiles = this.baobaoImagesInfo.getChosedFiles();
        return !afY && (chosedFiles == null || chosedFiles.isEmpty());
    }

    private void M(Intent intent) {
        this.aBK = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aBK;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cb = com.baidu.tbadk.core.util.d.cb(str);
                if (cb != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.d.b(str, com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.M(getPageContext().getPageActivity())), com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.N(getPageContext().getPageActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.d.h(b, cb);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.aBK, h, 100);
                    h.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            this.bWk.a(this.writeImagesInfo, true);
        }
        eR(true);
    }

    private void L(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    this.bWk.a(this.writeImagesInfo, z);
                }
            }
            eR(true);
        }
    }

    private void N(Intent intent) {
        if (this.bPp != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(stringExtra);
            this.baobaoImagesInfo.clear();
            this.baobaoImagesInfo.addChooseFile(imageFileInfo);
            this.bPp.setIsBaobao(true);
            this.bPp.setBaobaoContent(stringExtra2);
            this.bWk.setBaobaoUris(this.baobaoImagesInfo);
            eS(true);
        }
    }

    private void Fu() {
        new bg(this).execute(new Void[0]);
    }

    private void eR(boolean z) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() > 0) {
            this.cgA.ee(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            this.bWk.ee(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            if (this.bWk.afN() || z) {
                this.bWk.afT();
                return;
            }
            return;
        }
        this.cgA.vx();
        this.bWk.vx();
        if (this.bWk.afY()) {
            this.bWk.vF();
            this.cgA.agt();
        }
        akE();
    }

    private void eS(boolean z) {
        LinkedList<ImageFileInfo> chosedFiles = this.baobaoImagesInfo.getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() > 0) {
            this.cgA.agI();
            this.cgA.agt();
            if (this.bWk.afN() || z) {
                this.bWk.afV();
            }
            this.bPp.setIsBaobao(true);
            return;
        }
        if (akM()) {
            this.cgA.agu();
        }
        this.bPp.setIsBaobao(false);
        this.cgA.agH();
        akE();
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
            antiData.setBlock_forum_name(this.bPp.getForumName());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.WRITE);
        } else if (this.cgB == null) {
            com.baidu.tieba.tbadkCore.f.g.d(getPageContext().getPageActivity(), fVar.getErrorString(), fVar.aiI(), fVar.aiJ());
        } else {
            m(z, str);
        }
    }

    public void a(boolean z, AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.bPp.getForumName());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.WRITE);
        } else if (this.cgB == null) {
            com.baidu.tieba.tbadkCore.f.g.M(getPageContext().getPageActivity(), str);
        } else {
            m(z, str);
        }
    }

    private void Z(Intent intent) {
        int size;
        M(intent);
        int size2 = this.writeImagesInfo.size() - 1;
        if (size2 > -1 && this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size2)));
        }
    }

    private void aa(Intent intent) {
        S(intent);
        adk();
        this.bWk.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.ci
    public void hB(int i) {
        this.bPq = i;
        this.bPN.setCurrentIndex(i);
        this.bPM.setText(this.mPrefixData.getPrefixs().get(i));
        adk();
        com.baidu.adp.lib.g.k.a(this.bPN, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.bPP.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
