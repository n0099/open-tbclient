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
    private com.baidu.tieba.tbadkCore.location.d aBC;
    private String aBH;
    private com.baidu.tieba.tbadkCore.f.a aBJ;
    private View bPH;
    private TextView bPL;
    private ch bPM;
    private ImageView bPN;
    private View bPO;
    private int bPp;
    private AdditionData cgA;
    private RelativeLayout cgB;
    private TextView cgC;
    private TextView cgD;
    private TextView cgE;
    private RelativeLayout cgG;
    private TextView cgH;
    private View cgI;
    private LiveBroadcastCard cgJ;
    private com.baidu.tieba.view.g cgQ;
    private Toast cgx;
    private GestureDetector mGestureDetector;
    private PostPrefixData mPrefixData;
    private VoiceManager mVoiceManager;
    private WriteData bPo = null;
    private boolean cgo = false;
    private boolean cgp = false;
    private InputMethodManager mInputManager = null;
    private EditText bPF = null;
    private View bPG = null;
    private LinearLayout bPI = null;
    private EditText bPJ = null;
    private o cgq = null;
    private FeedBackTopListView cgr = null;
    private String bVa = null;
    private final KeyEvent cgs = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView cgt = null;
    private TextView bPK = null;
    private TextView aAn = null;
    private DialogInterface.OnCancelListener bHF = null;
    private com.baidu.tbadk.core.dialog.a cgu = null;
    private final Handler mHandler = new Handler();
    private boolean cgv = false;
    private String cgw = null;
    private RelativeLayout mParent = null;
    private String bAq = null;
    private com.baidu.tieba.tbadkCore.PbEditor.k cgy = null;
    private TbEditorToolButtonContainer cgz = null;
    private EditorToolComponetContainer bWj = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private int cgF = 0;
    private HttpMessageListener cgK = new ac(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private final com.baidu.tieba.tbadkCore.f.c aDz = new an(this);
    private com.baidu.tieba.tbadkCore.location.i aBN = new az(this);
    private View.OnClickListener cgL = new bh(this);
    private CustomMessageListener car = new bi(this, 2001232);
    private final Runnable cgM = new bj(this);
    private final View.OnClickListener cgN = new bk(this);
    private boolean cgO = true;
    private final View.OnFocusChangeListener bPD = new bl(this);
    private final CustomMessageListener cgP = new bm(this, 2001310);
    private com.baidu.tieba.tbadkCore.bubble.y aGe = new ad(this);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(WriteActivityConfig.class, WriteActivity.class);
        com.baidu.tieba.tbadkCore.location.d.aid();
    }

    public void Fj() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Fk() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(com.baidu.tieba.z.location_system_permission_prompt);
            this.cgy.setLocationInfoViewState(0);
        } else if (!TbadkCoreApplication.m255getInst().getLocationShared()) {
            Fl();
        } else if (this.aBC.aic()) {
            Fj();
        } else {
            this.aBC.eE(false);
            this.cgy.setLocationInfoViewState(1);
            this.aBC.aia();
        }
    }

    private void Fl() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.by(com.baidu.tieba.z.location_app_permission_prompt).a(com.baidu.tieba.z.isopen, new ae(this)).b(com.baidu.tieba.z.cancel, new af(this)).b(getPageContext());
        aVar.nQ();
    }

    public int akp() {
        int selectionEnd = this.bPJ.getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) this.bPJ.getText().getSpans(0, this.bPJ.getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = this.bPJ.getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = this.bPJ.getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    public void akq() {
        if (!this.cgO) {
            this.cgz.afp();
        } else {
            this.cgz.afq();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        this.bWj.afX();
        if (this.cgQ != null && this.bPo != null && this.bPo.getLiveCardData() != null) {
            new Handler().postDelayed(new ag(this, new Date(this.bPo.getLiveCardData().getStartTime() * 1000)), 100L);
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
        this.bWj.afV();
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
        akv();
        MessageManager.getInstance().unRegisterListener(getUniqueId());
        this.cgP.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.cgP);
        this.aBC = new com.baidu.tieba.tbadkCore.location.d(this);
        this.aBC.a(this.aBN);
        registerListener(this.car);
        if (this.cgA == null) {
            Fm();
        }
        this.bPJ.requestFocus();
    }

    public void ajc() {
        boolean appResponseToCmd = TbadkCoreApplication.m255getInst().appResponseToCmd(2802001);
        if (!TbadkCoreApplication.m255getInst().isBaobaoShouldOpen() || this.cgA != null || !appResponseToCmd) {
            this.cgz.agG();
        }
    }

    private void Fm() {
        if (this.aBC.aie()) {
            if (this.aBC.aic()) {
                this.cgy.B(2, com.baidu.tieba.tbadkCore.location.c.ahX().getLocationData().ahT());
                return;
            }
            this.cgy.setLocationInfoViewState(1);
            this.aBC.aia();
            return;
        }
        this.cgy.setLocationInfoViewState(0);
    }

    public void acX() {
        if (this.aBJ != null) {
            this.aBJ.cancelLoadData();
        }
        if (this.cgq != null) {
            this.cgq.cancelLoadData();
        }
        if (this.aBC != null) {
            this.aBC.cancelLoadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        acX();
        akE();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
    }

    public void akr() {
        if (this.bPo != null && this.bPo.getType() == 2 && this.cgv) {
            finish();
        } else if (this.bPo == null) {
            finish();
        } else {
            this.bPo.setTitle(this.bPF.getText().toString());
            this.bPo.setContent(this.bPJ.getText().toString());
            int type = this.bPo.getType();
            if (this.bPo.getHaveDraft() && com.baidu.adp.lib.util.k.isEmpty(this.bPo.getTitle()) && com.baidu.adp.lib.util.k.isEmpty(this.bPo.getContent()) && !this.bPo.isHasImages()) {
                if (type == 0) {
                    if (this.bPo.getLiveCardData() == null) {
                        com.baidu.tieba.tbadkCore.al.a(this.bPo.getForumId(), (WriteData) null);
                    } else {
                        com.baidu.tieba.tbadkCore.al.a(this.bPo.getLiveCardData().getGroupId(), (WriteData) null);
                    }
                } else if (type == 1) {
                    com.baidu.tieba.tbadkCore.al.b(this.bPo.getThreadId(), (WriteData) null);
                }
            } else if (type == 0) {
                if (this.bPo.getLiveCardData() == null) {
                    com.baidu.tieba.tbadkCore.al.a(this.bPo.getForumId(), this.bPo);
                } else {
                    com.baidu.tieba.tbadkCore.al.a(this.bPo.getLiveCardData().getGroupId(), this.bPo);
                }
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.al.b(this.bPo.getThreadId(), this.bPo);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bPM != null && this.bPM.isShowing()) {
                com.baidu.adp.lib.g.k.a(this.bPM, getPageContext().getPageActivity());
                return true;
            } else if (this.bWj.afI()) {
                this.cgz.afr();
                this.bWj.hideAll();
                return true;
            } else {
                acX();
                akr();
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
        com.baidu.tbadk.core.util.bc.g(this.bPK, i);
        akq();
        com.baidu.tbadk.core.util.bc.j(this.bPG, com.baidu.tieba.t.cp_bg_line_c);
        com.baidu.tbadk.core.util.bc.j(this.bPH, com.baidu.tieba.t.cp_bg_line_c);
        com.baidu.tbadk.core.util.bc.j((View) this.bPF, com.baidu.tieba.t.cp_bg_line_d);
        if (TextUtils.isEmpty(this.bVa)) {
            com.baidu.tbadk.core.util.bc.j((View) this.bPJ, com.baidu.tieba.t.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.bc.getColor(com.baidu.tieba.t.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.bc.getColor(com.baidu.tieba.t.cp_cont_e);
        this.cgz.changeSkinType(i);
        this.bPF.setTextColor(color);
        this.bPJ.setTextColor(color);
        a(this.bPF, color2);
        a(this.bPJ, color2);
        adf();
        this.bWj.onChangeSkinType(i);
        this.cgy.wo();
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
        this.aAn = this.mNavigationBar.setTitleText("");
        this.cgt = (TextView) findViewById(com.baidu.tieba.w.btn_image_problem);
        this.bPK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(com.baidu.tieba.z.send_post));
        this.bPK.setOnFocusChangeListener(this.bPD);
        addGlobalLayoutListener();
        this.cgr = (FeedBackTopListView) findViewById(com.baidu.tieba.w.feedback_top_list);
        this.mParent = (RelativeLayout) findViewById(com.baidu.tieba.w.parent);
        this.bPG = findViewById(com.baidu.tieba.w.interval_view);
        this.bPH = findViewById(com.baidu.tieba.w.prefix_interval_view);
        ade();
        this.mHandler.postDelayed(this.cgM, 200L);
        adg();
        if (this.cgo || this.cgp) {
            getWindow().setSoftInputMode(18);
            if (CDNIPDirectConnect.pQ().hasImageProblem()) {
                findViewById(com.baidu.tieba.w.ll_image_problem).setVisibility(0);
            } else {
                findViewById(com.baidu.tieba.w.ll_image_problem).setVisibility(8);
            }
        }
        this.bPI = (LinearLayout) findViewById(com.baidu.tieba.w.post_content_container);
        this.bPI.setDrawingCacheEnabled(false);
        this.bPI.setOnClickListener(new ah(this));
        this.mBack.setOnFocusChangeListener(this.bPD);
        this.mBack.setOnClickListener(new ai(this));
        this.cgt.setOnClickListener(new aj(this));
        this.cgy = new com.baidu.tieba.tbadkCore.PbEditor.k((EditorInfoContainer) findViewById(com.baidu.tieba.w.write_editor_info));
        this.cgy.H(this.cgL);
        if (this.cgA != null) {
            this.cgy.destroy();
        }
        g(akF());
        akB();
        aky();
        akw();
        ajc();
        if (this.bPo.getType() == 0) {
            if (this.cgo || this.cgp) {
                this.cgz.agG();
                this.aAn.setText(com.baidu.tieba.z.feedback);
            } else {
                this.aAn.setText(com.baidu.tieba.z.post_new_thread);
            }
            this.bPF.setVisibility(0);
            this.bPJ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
        } else {
            this.aAn.setText(com.baidu.tieba.z.send_reply);
            this.bPJ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
            this.bPF.setVisibility(8);
        }
        akx();
        akD();
        akq();
        aku();
        add();
        akt();
        adf();
        if (this.bPo.getLiveCardData() == null) {
            ShowSoftKeyPad(this.mInputManager, this.bPF);
        }
        aks();
    }

    private void aks() {
        if (this.bWj != null) {
            int skinType = TbadkCoreApplication.m255getInst().getSkinType();
            this.bWj.setShadowHeight(getResources().getDimensionPixelSize(com.baidu.tieba.u.ds1));
            if (skinType == 1) {
                this.bWj.setShadowBackground(com.baidu.tieba.t.cp_bg_line_b_1);
            } else {
                this.bWj.setShadowBackground(com.baidu.tieba.t.cp_cont_e);
            }
        }
    }

    private void akt() {
        this.cgG = (RelativeLayout) findViewById(com.baidu.tieba.w.live_time_rel);
        this.cgH = (TextView) findViewById(com.baidu.tieba.w.live_tiem_show);
        this.cgI = findViewById(com.baidu.tieba.w.interval_view2);
        this.cgJ = (LiveBroadcastCard) findViewById(com.baidu.tieba.w.live_anchor_card);
        this.cgG.setOnClickListener(new ak(this));
        this.cgG.setOnTouchListener(new al(this));
        if (this.bPo.getLiveCardData() != null) {
            this.cgG.setVisibility(0);
            this.cgI.setVisibility(0);
            this.cgJ.setVisibility(0);
            this.cgJ.setClickable(false);
            this.cgH.setText(com.baidu.tbadk.core.util.bf.o(this.bPo.getLiveCardData().getStartTime() * 1000));
            this.cgJ.setData(this.bPo.getLiveCardData());
            return;
        }
        this.cgG.setVisibility(8);
        this.cgI.setVisibility(8);
        this.cgJ.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if ((dialog instanceof com.baidu.tieba.view.g) && this.bPo.getLiveCardData() != null) {
            Date date = new Date(this.bPo.getLiveCardData().getStartTime() * 1000);
            ((com.baidu.tieba.view.g) dialog).updateTime(date.getHours(), date.getMinutes());
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.cgQ = new com.baidu.tieba.view.g(getPageContext().getPageActivity(), new am(this), new Date().getHours(), new Date().getMinutes(), false);
        this.cgQ.setTitle(com.baidu.tieba.z.no_disturb_start_time);
        this.cgQ.setButton(-1, getPageContext().getString(com.baidu.tieba.z.alert_yes_button), this.cgQ);
        this.cgQ.setButton(-2, getPageContext().getString(com.baidu.tieba.z.alert_no_button), this.cgQ);
        return this.cgQ;
    }

    private void aku() {
        this.cgB = (RelativeLayout) findViewById(com.baidu.tieba.w.addition_container);
        this.cgC = (TextView) findViewById(com.baidu.tieba.w.addition_create_time);
        this.cgD = (TextView) findViewById(com.baidu.tieba.w.addition_last_time);
        this.cgE = (TextView) findViewById(com.baidu.tieba.w.addition_last_content);
        if (this.cgA != null) {
            this.cgB.setVisibility(0);
            this.cgC.setText(String.valueOf(getPageContext().getString(com.baidu.tieba.z.write_addition_create)) + com.baidu.tbadk.core.util.bf.n(this.cgA.getCreateTime() * 1000));
            if (this.cgA.getAlreadyCount() == 0) {
                this.cgD.setVisibility(8);
            } else {
                this.cgD.setText(String.valueOf(getPageContext().getString(com.baidu.tieba.z.write_addition_last)) + com.baidu.tbadk.core.util.bf.n(this.cgA.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.cgA.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.cgE.setText(lastAdditionContent);
            } else {
                this.cgE.setVisibility(8);
            }
            this.bPJ.setHint(String.format(getPageContext().getString(com.baidu.tieba.z.write_addition_hint), Integer.valueOf(this.cgA.getAlreadyCount()), Integer.valueOf(this.cgA.getTotalCount())));
            this.aAn.setText(com.baidu.tieba.z.write_addition_title);
            return;
        }
        this.cgB.setVisibility(8);
    }

    private void add() {
        this.bPO = findViewById(com.baidu.tieba.w.post_prefix_layout);
        this.bPL = (TextView) findViewById(com.baidu.tieba.w.post_prefix);
        this.bPN = (ImageView) findViewById(com.baidu.tieba.w.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.bPO.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.bPL.setText(prefixs.get(0));
            this.bPp = 0;
            this.bPO.setOnClickListener(new ao(this));
            this.bPN = (ImageView) findViewById(com.baidu.tieba.w.prefix_icon);
            if (size > 1) {
                this.bPN.setVisibility(0);
                this.bPL.setOnClickListener(new ap(this));
            }
            this.bPM = new ch(getPageContext().getPageActivity());
            this.bPM.a(this);
            this.bPM.setMaxHeight(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 225.0f));
            this.bPM.setOutsideTouchable(true);
            this.bPM.setFocusable(true);
            this.bPM.setOnDismissListener(this);
            this.bPM.setBackgroundDrawable(com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.t.cp_bg_line_b));
            int color = com.baidu.tbadk.core.util.bc.getColor(com.baidu.tieba.t.write_text);
            com.baidu.tbadk.core.util.bc.i((View) this.bPL, com.baidu.tieba.v.write_prefix_item_selector);
            com.baidu.tbadk.core.util.bc.c(this.bPN, com.baidu.tieba.v.icon_title_down);
            this.bPL.setTextColor(color);
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
                this.bPM.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), getResources().getDimension(com.baidu.tieba.u.ds6)), 0, com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), getResources().getDimension(com.baidu.tieba.u.ds22)), 0);
                }
            }
            this.bPM.setCurrentIndex(0);
            return;
        }
        this.bPO.setVisibility(8);
    }

    private void akv() {
        if (this.cgo && this.bPo != null) {
            this.cgr.setVisibility(0);
            this.cgq = new o(this);
            this.cgq.iB(this.bPo.getForumName());
            this.cgq.setLoadDataCallBack(new aq(this));
        }
    }

    protected void akw() {
        this.bPK.setOnClickListener(new ar(this));
    }

    protected void akx() {
        this.cgu = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.cgu.bT(getPageContext().getString(com.baidu.tieba.z.is_save_draft)).ah(false).a(getPageContext().getString(com.baidu.tieba.z.save), new as(this)).b(getPageContext().getString(com.baidu.tieba.z.not_save), new au(this));
        this.cgu.b(getPageContext());
    }

    protected void ade() {
        this.bPF = (EditText) findViewById(com.baidu.tieba.w.post_title);
        this.bPF.setOnClickListener(this.cgN);
        this.bPF.setOnFocusChangeListener(this.bPD);
        if (this.bPo.getType() == 0) {
            if (this.bPo.getTitle() != null) {
                this.bPF.setText(this.bPo.getTitle());
                this.bPF.setSelection(this.bPo.getTitle().length());
            }
        } else if (this.bPo.getType() != 1) {
            this.bPo.getType();
        }
        this.bPF.addTextChangedListener(new av(this));
    }

    protected void adg() {
        this.bPJ = (EditText) findViewById(com.baidu.tieba.w.post_content);
        this.bPJ.setDrawingCacheEnabled(false);
        this.bPJ.setOnClickListener(this.cgN);
        if (this.bPo.getContent() != null && this.bPo.getContent().length() > 0) {
            SpannableString E = TbFaceManager.vX().E(getPageContext().getPageActivity(), this.bPo.getContent());
            this.bPJ.setText(E);
            this.bPJ.setSelection(E.length());
        } else if (this.bPo.getType() == 2) {
            if (this.cgv) {
                if (this.cgw != null && this.cgw.length() > 0) {
                    this.bPJ.setText(getPageContext().getPageActivity().getString(com.baidu.tieba.z.reply_sub_floor, new Object[]{this.cgw}));
                    this.bPJ.setSelection(this.bPJ.getText().length());
                }
            } else if (this.bPo.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(com.baidu.tieba.z.reply_x_floor), Integer.valueOf(this.bPo.getFloorNum()));
                this.bPJ.setText(format);
                this.bPJ.setSelection(format.length());
            }
        }
        this.bPJ.setOnFocusChangeListener(this.bPD);
        this.bPJ.setOnTouchListener(new aw(this));
        this.bPJ.addTextChangedListener(new ax(this));
        eQ(true);
    }

    public void eQ(boolean z) {
        if (TbadkCoreApplication.m255getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class)) {
            this.bPJ.setPadding(0, 0, 0, 0);
            this.bPJ.setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.bc.j((View) this.bPJ, com.baidu.tieba.t.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.bVa) && this.cgA == null) {
                com.baidu.adp.lib.f.d.ec().a(this.bVa, 19, new ay(this, z), getUniqueId());
            }
        }
    }

    public boolean FD() {
        int i = 5000;
        if (this.cgA != null) {
            i = 1000;
        }
        return this.bPJ.getText() != null && this.bPJ.getText().length() >= i;
    }

    protected void aky() {
        this.bWj = (EditorToolComponetContainer) findViewById(com.baidu.tieba.w.tool_group);
        this.bWj.setFrom(1);
        Boolean akF = akF();
        if (this.cgo || (akF != null && !akF.booleanValue())) {
            this.bWj.vD();
        } else {
            this.bWj.vC();
        }
        this.bWj.setOnActionListener(new ba(this));
        this.bWj.refresh();
    }

    protected void akz() {
        this.cgz.afr();
        if (this.bWj.afI()) {
            this.bWj.hideAll();
        }
    }

    public void akA() {
        this.bWj.X(this.bPJ);
    }

    public void it(int i) {
        if (this.bWj.afI()) {
            iu(i);
            return;
        }
        this.bWj.W(this.bPF);
        this.bWj.W(this.bPJ);
        new Handler().postDelayed(new bb(this, i), 200L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
        if (this.bWj != null) {
            this.bWj.afK();
        }
    }

    public void iu(int i) {
        if (i == 2) {
            this.cgz.agz();
            this.bWj.afM();
        } else if (i == 5 || i == 60) {
            this.bWj.afN();
        } else if (i == 8) {
            this.bWj.afO();
            this.cgz.agA();
        } else if (i == 50) {
            this.bWj.afQ();
            this.cgz.agD();
        } else if (i == 44) {
            this.bWj.afP();
            this.cgz.agB();
        } else if (i == 38) {
            this.bWj.afL();
            this.cgz.agE();
        } else if (i == 57) {
            this.bWj.afO();
            this.cgz.agA();
        } else if (i == 48) {
            this.bWj.afQ();
        }
    }

    protected void akB() {
        this.cgz = (TbEditorToolButtonContainer) findViewById(com.baidu.tieba.w.write_eidtor_tool_buttons);
        this.cgz.afq();
        this.cgz.setAtFocusable(false);
        this.cgz.setOnActionListener(new bc(this));
        if (TbadkCoreApplication.m255getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.cgz.ez(false);
        }
    }

    public void iv(int i) {
        if (this.bWj.afS()) {
            it(i);
        } else if (!com.baidu.tieba.tbadkCore.PbEditor.a.afg() && this.cgF == 0) {
            showToast(com.baidu.tieba.z.baobao_over_limit);
        } else {
            String charSequence = this.aAn.getText().toString();
            com.baidu.tbadk.core.frameworkData.a aVar = new com.baidu.tbadk.core.frameworkData.a(getPageContext().getPageActivity());
            aVar.getIntent().putExtra("title", charSequence);
            aVar.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
            sendMessage(new CustomMessage(2802001, aVar));
        }
    }

    public void a(com.baidu.tbadk.coreExtra.data.f fVar) {
        if (((ImageSpan[]) this.bPJ.getText().getSpans(0, this.bPJ.getText().length(), ImageSpan.class)).length >= 10) {
            if (this.cgx == null) {
                this.cgx = Toast.makeText(getPageContext().getPageActivity(), com.baidu.tieba.z.too_many_face, 0);
            }
            this.cgx.show();
            return;
        }
        String name = fVar.getName();
        EmotionGroupType rG = fVar.rG();
        if (name != null) {
            com.baidu.adp.lib.f.d.ec().a(name, 20, new bd(this, new SpannableStringBuilder(name), this.bPJ.getSelectionStart(), rG), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        Bitmap jc = aVar.jc();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(jc);
        int width = jc.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            width = (int) (0.5d * width);
        }
        bitmapDrawable.setBounds(0, 0, width + 1, width);
        bitmapDrawable.setGravity(119);
        spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
        this.bPJ.getText().insert(i, spannableStringBuilder);
    }

    public void akC() {
        this.bPJ.onKeyDown(67, this.cgs);
    }

    private void g(Boolean bool) {
        String str = null;
        if (this.bPo != null) {
            str = this.bPo.getForumName();
        }
        if (getPageContext().getString(com.baidu.tieba.z.feedback_bar_name).equals(str)) {
            this.cgo = true;
        }
    }

    private void akD() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void akE() {
        try {
            if (this.cgu != null) {
                this.cgu.dismiss();
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

    private Boolean akF() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.bAq = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void adf() {
        String str = null;
        if (this.bPo.getType() == 0) {
            String trim = this.bPF.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.bPp == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.bPo.setIsNoTitle(true);
                    } else {
                        this.bPo.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.bPo.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.bPo.setIsNoTitle(true);
            } else {
                this.bPo.setIsNoTitle(false);
                str = "1";
            }
        }
        String trim2 = this.bPJ.getText().toString().trim();
        if (this.bWj.afR()) {
            str = "1";
        } else if (!TextUtils.isEmpty(trim2)) {
            str = "1";
        } else if (this.bWj.afT()) {
            str = "1";
        } else if (this.bWj.afS()) {
            str = "1";
        }
        if (str == null || str.length() <= 0) {
            this.bPK.setEnabled(false);
        } else {
            this.bPK.setEnabled(true);
        }
    }

    private void initData(Bundle bundle) {
        this.aBJ = new com.baidu.tieba.tbadkCore.f.a(this);
        this.aBJ.a(this.aDz);
        registerListener(this.cgK);
        this.bHF = new be(this);
        this.bPo = new WriteData();
        if (bundle != null) {
            this.bPo.setType(bundle.getInt("type", 0));
            this.bPo.setForumId(bundle.getString("forum_id"));
            this.bPo.setForumName(bundle.getString("forum_name"));
            this.bPo.setThreadId(bundle.getString("thread_id"));
            this.bPo.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.bPo.setFloorNum(bundle.getInt(WriteActivityConfig.FLOOR_NUM, 0));
            this.cgo = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.cgv = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.cgw = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.baobaoImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.BAOBAO_IMAGES);
            this.aBH = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.cgA = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.bPo.setIsAddition(this.cgA != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.cgF = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
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
                this.bPo.setLiveCardData(liveCardData);
            }
        } else {
            Intent intent = getIntent();
            this.bPo.setType(intent.getIntExtra("type", 0));
            this.bPo.setForumId(intent.getStringExtra("forum_id"));
            this.bPo.setForumName(intent.getStringExtra("forum_name"));
            this.bPo.setThreadId(intent.getStringExtra("thread_id"));
            this.bPo.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.bPo.setFloorNum(intent.getIntExtra(WriteActivityConfig.FLOOR_NUM, 0));
            this.cgo = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.cgv = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.cgw = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.cgA = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.bPo.setIsAddition(this.cgA != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.cgF = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
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
                this.bPo.setLiveCardData(liveCardData2);
            }
        }
        this.baobaoImagesInfo.setMaxImagesAllowed(1);
        this.writeImagesInfo.setMaxImagesAllowed(10);
        this.bPo.setWriteImagesInfo(this.writeImagesInfo);
        this.bPo.setBaobaoImagesInfo(this.baobaoImagesInfo);
        if (this.bPo.getType() == 0) {
            if (this.bPo.getLiveCardData() == null) {
                com.baidu.tieba.tbadkCore.al.b(this.bPo.getForumId(), this);
            } else {
                com.baidu.tieba.tbadkCore.al.a(this.bPo.getLiveCardData().getGroupId(), this);
            }
        } else if (this.bPo.getType() == 1) {
            com.baidu.tieba.tbadkCore.al.a(this.bPo.getThreadId(), this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(com.baidu.tieba.z.write_no_prefix));
        }
        this.bVa = TbadkCoreApplication.m255getInst().getDefaultBubble();
        if (this.bPo != null && this.bPo.getForumName() != null && TbadkCoreApplication.m255getInst().getYijianfankuiFname() != null && this.bPo.getForumName().equals(TbadkCoreApplication.m255getInst().getYijianfankuiFname())) {
            this.cgp = true;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.am
    public void a(WriteData writeData) {
        if (writeData != null && this.bPo != null) {
            this.bPo.setHaveDraft(true);
            if (com.baidu.adp.lib.util.k.isEmpty(this.bPF.getText().toString()) || ((this.cgo || this.cgp) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                this.bPo.setTitle(writeData.getTitle());
                this.bPF.setText(this.bPo.getTitle());
                this.bPF.setSelection(this.bPo.getTitle().length());
            }
            if (writeData.getLiveCardData() != null) {
                Date date = new Date(writeData.getLiveCardData().getStartTime() * 1000);
                Date date2 = new Date();
                date.setYear(date2.getYear());
                date.setMonth(date2.getMonth());
                date.setDate(date2.getDate());
                this.bPo.getLiveCardData().setStartTime(date.getTime() / 1000);
                this.cgH.setText(com.baidu.tbadk.core.util.bf.o(this.bPo.getLiveCardData().getStartTime() * 1000));
            }
            if ((com.baidu.adp.lib.util.k.isEmpty(this.bPJ.getText().toString()) || this.cgo || this.cgp) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                this.bPo.setContent(writeData.getContent());
                SpannableString a = TbFaceManager.vX().a(getPageContext().getPageActivity(), this.bPo.getContent(), new bf(this));
                this.bPJ.setText(a);
                this.bPJ.setSelection(a.length());
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo = writeData.getWriteImagesInfo();
                this.bPo.setWriteImagesInfo(this.writeImagesInfo);
                this.bWj.a(this.writeImagesInfo, true);
                eR(false);
            }
            if (TbadkCoreApplication.m255getInst().isBaobaoShouldOpen()) {
                if (writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                    this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                    this.bPo.setIsBaobao(writeData.getIsBaobao());
                    this.bPo.setBaobaoContent(writeData.getBaobaoContent());
                    this.bPo.setBaobaoImagesInfo(this.baobaoImagesInfo);
                }
                if (this.bPo.getIsBaobao()) {
                    this.bWj.setBaobaoUris(this.baobaoImagesInfo);
                    eS(false);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.bPo.getType());
        bundle.putString("forum_id", this.bPo.getForumId());
        bundle.putString("forum_name", this.bPo.getForumName());
        bundle.putString("thread_id", this.bPo.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.bPo.getFloor());
        bundle.putInt(WriteActivityConfig.FLOOR_NUM, this.bPo.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.cgv);
        if (this.cgo) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putSerializable(WriteActivityConfig.BAOBAO_IMAGES, this.baobaoImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aBH);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.cgA);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.cgF);
        if (this.bPo.getLiveCardData() != null) {
            bundle.putBoolean(WriteActivityConfig.IS_LIVE_POST, true);
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ID, this.bPo.getLiveCardData().getGroupId());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_HEAD, this.bPo.getLiveCardData().getPortrait());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_INTRO, this.bPo.getLiveCardData().getIntro());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_NAME, this.bPo.getLiveCardData().getName());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_MEMBER_COUNT, this.bPo.getLiveCardData().getListeners());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ZAN_COUNT, this.bPo.getLiveCardData().getLikers());
            bundle.putLong(WriteActivityConfig.LIVE_DATE, this.bPo.getLiveCardData().getStartTime());
            bundle.putBoolean(WriteActivityConfig.LIVE_TIME_IS_MODIFY, this.bPo.getLiveCardData().isModifyTime());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_PUBLISH_HEAD, this.bPo.getLiveCardData().getPublisherPortrait());
        }
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = this.bPJ.getEditableText().toString();
        if (editable != null) {
            this.bPJ.setText(TbFaceManager.vX().E(getPageContext().getPageActivity(), editable));
            this.bPJ.setSelection(this.bPJ.getText().length());
        }
    }

    public void ada() {
        acX();
        if (this.bPo.getLiveCardData() != null) {
            if (!this.bPo.getLiveCardData().isModifyTime()) {
                this.bPo.getLiveCardData().setStartTime(new Date().getTime() / 1000);
                this.cgH.setText(com.baidu.tbadk.core.util.bf.o(this.bPo.getLiveCardData().getStartTime() * 1000));
            }
            long time = new Date().getTime() / TbConfig.USE_TIME_INTERVAL;
            Date date = new Date(this.bPo.getLiveCardData().getStartTime() * 1000);
            Date date2 = new Date();
            date.setYear(date2.getYear());
            date.setMonth(date2.getMonth());
            date.setDate(date2.getDate());
            this.bPo.getLiveCardData().setStartTime(date.getTime() / 1000);
            if (time > this.bPo.getLiveCardData().getStartTime() / 60) {
                showToast(com.baidu.tieba.z.live_start_time_error);
                return;
            }
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.bPp != this.mPrefixData.getPrefixs().size() - 1) {
            this.bPo.setTitle(String.valueOf(this.bPL.getText().toString()) + this.bPF.getText().toString());
        } else {
            this.bPo.setTitle(this.bPF.getText().toString());
        }
        this.bPo.setContent(this.bPJ.getText().toString());
        if (this.cgo || this.cgp) {
            String string = getResources().getString(com.baidu.tieba.z.android_feedback);
            if (TextUtils.isEmpty(this.bPo.getTitle()) || !this.bPo.getTitle().startsWith(string)) {
                this.bPo.setTitle(string + this.bPo.getTitle());
            }
            String str = String.valueOf(getResources().getString(com.baidu.tieba.z.app_name)) + getResources().getString(com.baidu.tieba.z.tieba_client);
            if (TextUtils.isEmpty(this.bPo.getContent()) || !this.bPo.getContent().startsWith(str)) {
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
                sb.append(this.bPo.getContent());
                this.bPo.setContent(sb.toString());
            }
        }
        this.bPo.setWriteImagesInfo(this.writeImagesInfo);
        this.bPo.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.bPo.setHasLocationData(this.cgy.getLocationInfoViewState() == 2);
        this.aBJ.eF(this.writeImagesInfo.size() > 0);
        this.aBJ.c(this.bPo);
        VoiceData.VoiceModel audioData = this.bWj.getAudioData();
        this.bWj.FI();
        this.bPo.setVcode(null);
        if (audioData != null) {
            if (audioData.getId() != null) {
                this.aBJ.Fn().setVoice(audioData.getId());
                this.aBJ.Fn().setVoiceDuringTime(audioData.duration);
            } else {
                this.aBJ.Fn().setVoice(null);
                this.aBJ.Fn().setVoiceDuringTime(-1);
            }
        } else {
            this.aBJ.Fn().setVoice(null);
            this.aBJ.Fn().setVoiceDuringTime(-1);
        }
        if (!this.aBJ.aiB()) {
            showToast(com.baidu.tieba.z.write_img_limit);
        } else if (this.aBJ.aiA()) {
            showLoadingDialog(getPageContext().getString(com.baidu.tieba.z.sending), this.bHF);
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
            if (this.cgA != null) {
                i2 = this.cgA.getTotalCount();
                i = this.cgA.getAlreadyCount() + 1;
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
                            this.bPJ.getText().insert(this.bPJ.getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                if (this.bPo.getType() == 0) {
                    com.baidu.tieba.tbadkCore.al.a(this.bPo.getForumId(), (WriteData) null);
                } else if (this.bPo.getType() == 1) {
                    com.baidu.tieba.tbadkCore.al.b(this.bPo.getThreadId(), (WriteData) null);
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
                adf();
            } else if (i == 12013) {
                N(intent);
                adf();
            } else if (i == 23004) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    Fo();
                    return;
                case 12002:
                    if (!this.bWj.afR()) {
                        akz();
                    }
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                        return;
                    }
                    return;
                case 12010:
                    this.aBH = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.bb.a(getPageContext(), this.aBH);
                    return;
                default:
                    return;
            }
        }
    }

    public void akG() {
        if (this.writeImagesInfo != null && !TextUtils.isEmpty(this.writeImagesInfo.toJsonString())) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), String.valueOf(System.currentTimeMillis()));
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.bPF);
        HidenSoftKeyPad(this.mInputManager, this.bPJ);
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void S(Intent intent) {
        b(intent, true);
    }

    public boolean akH() {
        boolean afT = this.bWj.afT();
        LinkedList<ImageFileInfo> chosedFiles = this.baobaoImagesInfo.getChosedFiles();
        return !afT && (chosedFiles == null || chosedFiles.isEmpty());
    }

    private void M(Intent intent) {
        this.aBH = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aBH;
        if (!TextUtils.isEmpty(str)) {
            try {
                int bY = com.baidu.tbadk.core.util.d.bY(str);
                if (bY != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.d.b(str, com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.M(getPageContext().getPageActivity())), com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.N(getPageContext().getPageActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.d.h(b, bY);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.aBH, h, 100);
                    h.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            this.bWj.a(this.writeImagesInfo, true);
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
                    this.bWj.a(this.writeImagesInfo, z);
                }
            }
            eR(true);
        }
    }

    private void N(Intent intent) {
        if (this.bPo != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(stringExtra);
            this.baobaoImagesInfo.clear();
            this.baobaoImagesInfo.addChooseFile(imageFileInfo);
            this.bPo.setIsBaobao(true);
            this.bPo.setBaobaoContent(stringExtra2);
            this.bWj.setBaobaoUris(this.baobaoImagesInfo);
            eS(true);
        }
    }

    private void Fo() {
        new bg(this).execute(new Void[0]);
    }

    private void eR(boolean z) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() > 0) {
            this.cgz.eb(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            this.bWj.eb(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            if (this.bWj.afI() || z) {
                this.bWj.afO();
                return;
            }
            return;
        }
        this.cgz.vr();
        this.bWj.vr();
        if (this.bWj.afT()) {
            this.bWj.vz();
            this.cgz.ago();
        }
        akz();
    }

    private void eS(boolean z) {
        LinkedList<ImageFileInfo> chosedFiles = this.baobaoImagesInfo.getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() > 0) {
            this.cgz.agD();
            this.cgz.ago();
            if (this.bWj.afI() || z) {
                this.bWj.afQ();
            }
            this.bPo.setIsBaobao(true);
            return;
        }
        if (akH()) {
            this.cgz.agp();
        }
        this.bPo.setIsBaobao(false);
        this.cgz.agC();
        akz();
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
            antiData.setBlock_forum_name(this.bPo.getForumName());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.WRITE);
        } else if (this.cgA == null) {
            com.baidu.tieba.tbadkCore.f.g.d(getPageContext().getPageActivity(), fVar.getErrorString(), fVar.aiD(), fVar.aiE());
        } else {
            m(z, str);
        }
    }

    public void a(boolean z, AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.bPo.getForumName());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.WRITE);
        } else if (this.cgA == null) {
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
        adf();
        this.bWj.setVisibility(0);
    }

    @Override // com.baidu.tieba.write.ci
    public void hB(int i) {
        this.bPp = i;
        this.bPM.setCurrentIndex(i);
        this.bPL.setText(this.mPrefixData.getPrefixs().get(i));
        adf();
        com.baidu.adp.lib.g.k.a(this.bPM, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.bPO.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
