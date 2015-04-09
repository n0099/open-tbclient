package com.baidu.tieba.write.write;

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
import com.baidu.tbadk.core.atomData.JigsawAlbumActivityConfig;
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
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.editor.EditorInfoContainer;
import com.baidu.tieba.write.editor.TbEditorToolButtonContainer;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, com.baidu.tbadk.core.voice.j, com.baidu.tieba.tbadkCore.ap, cn {
    private com.baidu.tieba.tbadkCore.location.e aHD;
    private String aHI;
    private com.baidu.tieba.tbadkCore.writeModel.a aHK;
    private int cvN;
    private TextView cwk;
    private cm cwl;
    private ImageView cwm;
    private View cwn;
    private View cxW;
    private Toast cyd;
    private AdditionData cyh;
    private RelativeLayout cyi;
    private TextView cyj;
    private TextView cyk;
    private TextView cyl;
    private RelativeLayout cyn;
    private TextView cyo;
    private View cyp;
    private LiveBroadcastCard cyq;
    private com.baidu.tieba.view.a cyw;
    private GestureDetector mGestureDetector;
    private PostPrefixData mPrefixData;
    private VoiceManager mVoiceManager;
    private WriteData cqk = null;
    private boolean cxS = false;
    private boolean cxT = false;
    private InputMethodManager mInputManager = null;
    private EditText cwe = null;
    private View cwf = null;
    private LinearLayout cwh = null;
    private EditText cwi = null;
    private s cxU = null;
    private FeedBackTopListView cxV = null;
    private ArrayList<com.baidu.tieba.write.view.j> cxX = new ArrayList<>();
    private String bAb = null;
    private final KeyEvent cxY = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView cxZ = null;
    private TextView cwj = null;
    private TextView aYa = null;
    private DialogInterface.OnCancelListener ccP = null;
    private com.baidu.tbadk.core.dialog.a cya = null;
    private final Handler mHandler = new Handler();
    private boolean cyb = false;
    private String cyc = null;
    private RelativeLayout aXd = null;
    private String bIf = null;
    private com.baidu.tieba.write.editor.b cye = null;
    private TbEditorToolButtonContainer cyf = null;
    private EditorToolComponetContainer cmP = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private boolean cyg = false;
    private int cym = 0;
    private final HttpMessageListener cyr = new ah(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private final com.baidu.tieba.tbadkCore.writeModel.e bIy = new as(this);
    private final com.baidu.tieba.tbadkCore.location.j aHP = new be(this);
    private final View.OnClickListener cys = new bm(this);
    private final CustomMessageListener cpK = new bn(this, 2001232);
    private final Runnable cyt = new bo(this);
    private final View.OnClickListener cyu = new bp(this);
    private boolean cyv = true;
    private final View.OnFocusChangeListener cwc = new bq(this);
    private final CustomMessageListener cmT = new br(this, 2001310);
    private final com.baidu.tieba.tbadkCore.b.h bMv = new ai(this);

    public void IO() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void IP() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(com.baidu.tieba.y.location_system_permission_prompt);
            this.cye.setLocationInfoViewState(0);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            IQ();
        } else if (this.aHD.anv()) {
            IO();
        } else {
            this.aHD.eP(false);
            this.cye.setLocationInfoViewState(1);
            this.aHD.ant();
        }
    }

    private void IQ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bx(com.baidu.tieba.y.location_app_permission_prompt).a(com.baidu.tieba.y.isopen, new aj(this)).b(com.baidu.tieba.y.cancel, new ak(this)).b(getPageContext());
        aVar.re();
    }

    public int aro() {
        int selectionEnd = this.cwi.getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) this.cwi.getText().getSpans(0, this.cwi.getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = this.cwi.getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = this.cwi.getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    public void arp() {
        if (!this.cyv) {
            this.cyf.alr();
        } else {
            this.cyf.als();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        this.cmP.alZ();
        if (this.cyw != null && this.cqk != null && this.cqk.getLiveCardData() != null) {
            new Handler().postDelayed(new al(this, new Date(this.cqk.getLiveCardData().getStartTime() * 1000)), 100L);
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
        this.cmP.alX();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BdLog.addLogPackage(WriteActivity.class.getPackage().getName());
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new bs(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        initUI();
        aru();
        MessageManager.getInstance().unRegisterListener(getUniqueId());
        this.cmT.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.cmT);
        this.aHD = new com.baidu.tieba.tbadkCore.location.e(this);
        this.aHD.a(this.aHP);
        registerListener(this.cpK);
        if (this.cyh == null) {
            IR();
        }
        this.cwi.requestFocus();
    }

    public void amj() {
        boolean appResponseToCmd = TbadkCoreApplication.m411getInst().appResponseToCmd(2802001);
        if (!TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() || this.cyh != null || !appResponseToCmd) {
            this.cyf.aqv();
        }
    }

    private void IR() {
        if (this.aHD.anx()) {
            if (this.aHD.anv()) {
                this.cye.B(2, com.baidu.tieba.tbadkCore.location.d.anq().getLocationData().anm());
                return;
            }
            this.cye.setLocationInfoViewState(1);
            this.aHD.ant();
            return;
        }
        this.cye.setLocationInfoViewState(0);
    }

    public void aqH() {
        if (this.aHK != null) {
            this.aHK.cancelLoadData();
        }
        if (this.cxU != null) {
            this.cxU.cancelLoadData();
        }
        if (this.aHD != null) {
            this.aHD.cancelLoadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        aqH();
        arD();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
    }

    public void arq() {
        if (this.cqk != null && this.cqk.getType() == 2 && this.cyb) {
            finish();
        } else if (this.cqk == null) {
            finish();
        } else {
            this.cqk.setTitle(this.cwe.getText().toString());
            this.cqk.setContent(this.cwi.getText().toString());
            int type = this.cqk.getType();
            if (this.cqk.getHaveDraft() && com.baidu.adp.lib.util.m.isEmpty(this.cqk.getTitle()) && com.baidu.adp.lib.util.m.isEmpty(this.cqk.getContent()) && !this.cqk.isHasImages()) {
                if (type == 0) {
                    if (this.cqk.getLiveCardData() == null) {
                        com.baidu.tieba.tbadkCore.ao.a(this.cqk.getForumId(), (WriteData) null);
                    } else {
                        com.baidu.tieba.tbadkCore.ao.a(this.cqk.getLiveCardData().getGroupId(), (WriteData) null);
                    }
                } else if (type == 1) {
                    com.baidu.tieba.tbadkCore.ao.b(this.cqk.getThreadId(), (WriteData) null);
                }
            } else if (type == 0) {
                if (this.cqk.getLiveCardData() == null) {
                    com.baidu.tieba.tbadkCore.ao.a(this.cqk.getForumId(), this.cqk);
                } else {
                    com.baidu.tieba.tbadkCore.ao.a(this.cqk.getLiveCardData().getGroupId(), this.cqk);
                }
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.ao.b(this.cqk.getThreadId(), this.cqk);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cwl != null && this.cwl.isShowing()) {
                com.baidu.adp.lib.g.k.a(this.cwl, getPageContext().getPageActivity());
                return true;
            } else if (this.cmP.alK()) {
                this.cyf.alt();
                this.cmP.hideAll();
                return true;
            } else {
                aqH();
                arq();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().X(i == 1);
        getLayoutMode().h(this.aXd);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.ba.g(this.cwj, i);
        arp();
        com.baidu.tbadk.core.util.ba.j(this.cwf, com.baidu.tieba.s.cp_bg_line_c);
        com.baidu.tbadk.core.util.ba.j((View) this.cwe, com.baidu.tieba.s.cp_bg_line_d);
        if (TextUtils.isEmpty(this.bAb)) {
            com.baidu.tbadk.core.util.ba.j((View) this.cwi, com.baidu.tieba.s.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.ba.getColor(com.baidu.tieba.s.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.ba.getColor(com.baidu.tieba.s.cp_cont_e);
        this.cyf.changeSkinType(i);
        this.cwe.setTextColor(color);
        this.cwi.setTextColor(color);
        a(this.cwe, color2);
        a(this.cwi, color2);
        aqP();
        this.cmP.onChangeSkinType(i);
        this.cye.rk();
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
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aYa = this.mNavigationBar.setTitleText("");
        this.cxZ = (TextView) findViewById(com.baidu.tieba.v.btn_image_problem);
        this.cwj = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(com.baidu.tieba.y.send_post));
        this.cwj.setOnFocusChangeListener(this.cwc);
        addGlobalLayoutListener();
        this.cxV = (FeedBackTopListView) findViewById(com.baidu.tieba.v.feedback_top_list);
        this.aXd = (RelativeLayout) findViewById(com.baidu.tieba.v.parent);
        this.cwf = findViewById(com.baidu.tieba.v.interval_view);
        aqO();
        aqQ();
        if (this.cxS || this.cxT) {
            getWindow().setSoftInputMode(18);
            if (!com.baidu.tbadk.core.util.httpNet.e.getInstance().Wd) {
                com.baidu.tbadk.core.util.httpNet.e.getInstance().init();
            }
            if (com.baidu.tbadk.core.util.httpNet.e.getInstance().hasImageProblem()) {
                findViewById(com.baidu.tieba.v.ll_image_problem).setVisibility(0);
            } else {
                findViewById(com.baidu.tieba.v.ll_image_problem).setVisibility(8);
            }
        }
        this.cwh = (LinearLayout) findViewById(com.baidu.tieba.v.post_content_container);
        this.cwh.setDrawingCacheEnabled(false);
        this.cwh.setOnClickListener(new am(this));
        this.mBack.setOnFocusChangeListener(this.cwc);
        this.mBack.setOnClickListener(new an(this));
        this.cxZ.setOnClickListener(new ao(this));
        this.cye = new com.baidu.tieba.write.editor.b((EditorInfoContainer) findViewById(com.baidu.tieba.v.write_editor_info));
        this.cye.C(this.cys);
        if (this.cyh != null) {
            this.cye.destroy();
        }
        f(arE());
        ars();
        arA();
        arx();
        arv();
        amj();
        if (this.cqk.getType() == 0) {
            if (this.cxS || this.cxT) {
                this.cyf.aqv();
                this.aYa.setText(com.baidu.tieba.y.feedback);
            } else {
                this.aYa.setText(com.baidu.tieba.y.post_new_thread);
            }
            this.cwe.setVisibility(0);
            this.cwi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
        } else {
            this.aYa.setText(com.baidu.tieba.y.send_reply);
            this.cwi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
            this.cwe.setVisibility(8);
        }
        arw();
        arC();
        arp();
        art();
        aqN();
        aqP();
        if (this.cqk.getLiveCardData() == null) {
            ShowSoftKeyPad(this.mInputManager, this.cwe);
        }
        arr();
    }

    private void arr() {
        if (this.cmP != null) {
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            this.cmP.setShadowHeight(getResources().getDimensionPixelSize(com.baidu.tieba.t.ds1));
            if (skinType == 1) {
                this.cmP.setShadowBackground(com.baidu.tieba.s.cp_bg_line_b_1);
            } else {
                this.cmP.setShadowBackground(com.baidu.tieba.s.cp_cont_e);
            }
        }
    }

    private void ars() {
        this.cyn = (RelativeLayout) findViewById(com.baidu.tieba.v.live_time_rel);
        this.cyo = (TextView) findViewById(com.baidu.tieba.v.live_tiem_show);
        this.cyp = findViewById(com.baidu.tieba.v.interval_view2);
        this.cyq = (LiveBroadcastCard) findViewById(com.baidu.tieba.v.live_anchor_card);
        this.cyn.setOnClickListener(new ap(this));
        this.cyn.setOnTouchListener(new aq(this));
        if (this.cqk.getLiveCardData() != null) {
            this.cyn.setVisibility(0);
            this.cyp.setVisibility(0);
            this.cyq.setVisibility(0);
            this.cyq.setClickable(false);
            this.cyo.setText(com.baidu.tbadk.core.util.bd.o(this.cqk.getLiveCardData().getStartTime() * 1000));
            this.cyq.setData(this.cqk.getLiveCardData());
            return;
        }
        this.cyn.setVisibility(8);
        this.cyp.setVisibility(8);
        this.cyq.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if ((dialog instanceof com.baidu.tieba.view.a) && this.cqk.getLiveCardData() != null) {
            Date date = new Date(this.cqk.getLiveCardData().getStartTime() * 1000);
            ((com.baidu.tieba.view.a) dialog).updateTime(date.getHours(), date.getMinutes());
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.cyw = new com.baidu.tieba.view.a(getPageContext().getPageActivity(), new ar(this), new Date().getHours(), new Date().getMinutes(), false);
        this.cyw.setTitle(com.baidu.tieba.y.no_disturb_start_time);
        this.cyw.setButton(-1, getPageContext().getString(com.baidu.tieba.y.alert_yes_button), this.cyw);
        this.cyw.setButton(-2, getPageContext().getString(com.baidu.tieba.y.alert_no_button), this.cyw);
        return this.cyw;
    }

    private void art() {
        this.cyi = (RelativeLayout) findViewById(com.baidu.tieba.v.addition_container);
        this.cyj = (TextView) findViewById(com.baidu.tieba.v.addition_create_time);
        this.cyk = (TextView) findViewById(com.baidu.tieba.v.addition_last_time);
        this.cyl = (TextView) findViewById(com.baidu.tieba.v.addition_last_content);
        if (this.cyh != null) {
            this.cyi.setVisibility(0);
            this.cyj.setText(String.valueOf(getPageContext().getString(com.baidu.tieba.y.write_addition_create)) + com.baidu.tbadk.core.util.bd.n(this.cyh.getCreateTime() * 1000));
            if (this.cyh.getAlreadyCount() == 0) {
                this.cyk.setVisibility(8);
            } else {
                this.cyk.setText(String.valueOf(getPageContext().getString(com.baidu.tieba.y.write_addition_last)) + com.baidu.tbadk.core.util.bd.n(this.cyh.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.cyh.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.cyl.setText(lastAdditionContent);
            } else {
                this.cyl.setVisibility(8);
            }
            this.cwi.setHint(String.format(getPageContext().getString(com.baidu.tieba.y.write_addition_hint), Integer.valueOf(this.cyh.getAlreadyCount()), Integer.valueOf(this.cyh.getTotalCount())));
            this.aYa.setText(com.baidu.tieba.y.write_addition_title);
            return;
        }
        this.cyi.setVisibility(8);
    }

    private void aqN() {
        this.cwn = findViewById(com.baidu.tieba.v.post_prefix_layout);
        this.cwk = (TextView) findViewById(com.baidu.tieba.v.post_prefix);
        this.cxW = findViewById(com.baidu.tieba.v.prefix_divider);
        this.cwm = (ImageView) findViewById(com.baidu.tieba.v.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.cwn.setVisibility(0);
            this.cxW.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.cvN = 0;
            this.cwn.setOnClickListener(new at(this));
            this.cwm = (ImageView) findViewById(com.baidu.tieba.v.prefix_icon);
            if (size > 1) {
                this.cwm.setVisibility(0);
                this.cwk.setOnClickListener(new au(this));
            }
            this.cwl = new cm(getPageContext().getPageActivity());
            this.cwl.a(this);
            this.cwl.setMaxHeight(com.baidu.adp.lib.util.n.d(getActivity(), com.baidu.tieba.t.ds510));
            this.cwl.setOutsideTouchable(true);
            this.cwl.setFocusable(true);
            this.cwl.setOnDismissListener(this);
            this.cwl.setBackgroundDrawable(com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.s.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.ba.getColor(com.baidu.tieba.s.write_text);
            int color2 = com.baidu.tbadk.core.util.ba.getColor(com.baidu.tieba.s.cp_cont_c);
            com.baidu.tbadk.core.util.ba.i((View) this.cwk, com.baidu.tieba.s.cp_bg_line_d);
            com.baidu.tbadk.core.util.ba.c(this.cwm, com.baidu.tieba.u.icon_title_down);
            this.cwk.setTextColor(color);
            this.cxX.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.view.j jVar = new com.baidu.tieba.write.view.j(getActivity());
                this.cxX.add(jVar);
                jVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    jVar.setPrefixTextColor(color2);
                } else {
                    jVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    jVar.setDividerStyle(false);
                }
                this.cwl.addView(jVar);
            }
            this.cwl.setCurrentIndex(0);
            this.cwk.setText(prefixs.get(1));
            jk(1);
            return;
        }
        this.cwn.setVisibility(8);
    }

    private void aru() {
        if (this.cxS && this.cqk != null) {
            this.cxV.setVisibility(0);
            this.cxU = new s(this);
            this.cxU.jk(this.cqk.getForumName());
            this.cxU.setLoadDataCallBack(new av(this));
        }
    }

    protected void arv() {
        this.cwj.setOnClickListener(new aw(this));
    }

    protected void arw() {
        this.cya = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.cya.ca(getPageContext().getString(com.baidu.tieba.y.is_save_draft)).ac(false).a(getPageContext().getString(com.baidu.tieba.y.save), new ax(this)).b(getPageContext().getString(com.baidu.tieba.y.not_save), new az(this));
        this.cya.b(getPageContext());
    }

    protected void aqO() {
        this.cwe = (EditText) findViewById(com.baidu.tieba.v.post_title);
        this.cwe.setOnClickListener(this.cyu);
        this.cwe.setOnFocusChangeListener(this.cwc);
        if (this.cqk.getType() == 0) {
            if (this.cqk.getTitle() != null) {
                this.cwe.setText(this.cqk.getTitle());
                this.cwe.setSelection(this.cqk.getTitle().length());
            }
        } else if (this.cqk.getType() != 1) {
            this.cqk.getType();
        }
        this.cwe.addTextChangedListener(new ba(this));
    }

    protected void aqQ() {
        this.cwi = (EditText) findViewById(com.baidu.tieba.v.post_content);
        this.cwi.setDrawingCacheEnabled(false);
        this.cwi.setOnClickListener(this.cyu);
        if (this.cqk.getContent() != null && this.cqk.getContent().length() > 0) {
            SpannableString E = TbFaceManager.zx().E(getPageContext().getPageActivity(), this.cqk.getContent());
            this.cwi.setText(E);
            this.cwi.setSelection(E.length());
        } else if (this.cqk.getType() == 2) {
            if (this.cyb) {
                if (this.cyc != null && this.cyc.length() > 0) {
                    this.cwi.setText(getPageContext().getPageActivity().getString(com.baidu.tieba.y.reply_sub_floor, new Object[]{this.cyc}));
                    this.cwi.setSelection(this.cwi.getText().length());
                }
            } else if (this.cqk.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(com.baidu.tieba.y.reply_x_floor), Integer.valueOf(this.cqk.getFloorNum()));
                this.cwi.setText(format);
                this.cwi.setSelection(format.length());
            }
        }
        this.cwi.setOnFocusChangeListener(this.cwc);
        this.cwi.setOnTouchListener(new bb(this));
        this.cwi.addTextChangedListener(new bc(this));
        fj(true);
    }

    public void fj(boolean z) {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class)) {
            this.cwi.setPadding(0, 0, 0, 0);
            this.cwi.setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.ba.j((View) this.cwi, com.baidu.tieba.s.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.bAb) && this.cyh == null) {
                com.baidu.adp.lib.f.d.hB().a(this.bAb, 19, new bd(this, z), getUniqueId());
            }
        }
    }

    public boolean Ji() {
        int i = 5000;
        if (this.cyh != null) {
            i = 1000;
        }
        return this.cwi.getText() != null && this.cwi.getText().length() >= i;
    }

    protected void arx() {
        this.cmP = (EditorToolComponetContainer) findViewById(com.baidu.tieba.v.tool_group);
        this.cmP.setFrom(1);
        Boolean arE = arE();
        if (this.cxS || (arE != null && !arE.booleanValue())) {
            this.cmP.zi();
        } else if (this.cqk.getLiveCardData() != null) {
            this.cmP.zh();
        } else {
            this.cmP.zg();
        }
        this.cmP.setOnActionListener(new bf(this));
        this.cmP.refresh();
    }

    protected void ary() {
        this.cyf.alt();
        if (this.cmP.alK()) {
            this.cmP.hideAll();
        }
    }

    public void arz() {
        this.cmP.aa(this.cwi);
    }

    public void jh(int i) {
        if (this.cmP.alK()) {
            ji(i);
            return;
        }
        this.cmP.Z(this.cwe);
        this.cmP.Z(this.cwi);
        new Handler().postDelayed(new bg(this, i), 200L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
        if (this.cmP != null) {
            this.cmP.alM();
        }
    }

    public void ji(int i) {
        if (i == 2) {
            this.cyf.aqo();
            this.cmP.alO();
        } else if (i == 5 || i == 60) {
            this.cmP.alP();
        } else if (i == 8) {
            this.cmP.alQ();
            this.cyf.aqp();
        } else if (i == 50) {
            this.cmP.alS();
            this.cyf.aqs();
        } else if (i == 44) {
            this.cmP.alR();
            this.cyf.aqq();
        } else if (i == 38) {
            this.cmP.alN();
            this.cyf.aqt();
        } else if (i == 57) {
            this.cmP.alQ();
            this.cyf.aqp();
        } else if (i == 48) {
            this.cmP.alS();
        }
    }

    protected void arA() {
        this.cyf = (TbEditorToolButtonContainer) findViewById(com.baidu.tieba.v.write_eidtor_tool_buttons);
        this.cyf.als();
        this.cyf.setAtFocusable(false);
        this.cyf.setOnActionListener(new bh(this));
        if (TbadkCoreApplication.m411getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.cyf.fe(false);
        }
    }

    public void jj(int i) {
        if (this.cmP.alU()) {
            jh(i);
        } else if (!com.baidu.tieba.tbadkCore.PbEditor.a.alk() && this.cym == 0) {
            showToast(com.baidu.tieba.y.baobao_over_limit);
        } else {
            String charSequence = this.aYa.getText().toString();
            com.baidu.tbadk.core.frameworkData.a aVar = new com.baidu.tbadk.core.frameworkData.a(getPageContext().getPageActivity());
            aVar.getIntent().putExtra("title", charSequence);
            aVar.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
            sendMessage(new CustomMessage(2802001, aVar));
        }
    }

    public void a(com.baidu.tbadk.coreExtra.data.f fVar) {
        if (((ImageSpan[]) this.cwi.getText().getSpans(0, this.cwi.getText().length(), ImageSpan.class)).length >= 10) {
            if (this.cyd == null) {
                this.cyd = Toast.makeText(getPageContext().getPageActivity(), com.baidu.tieba.y.too_many_face, 0);
            }
            this.cyd.show();
            return;
        }
        String name = fVar.getName();
        EmotionGroupType uD = fVar.uD();
        if (name != null) {
            com.baidu.adp.lib.f.d.hB().a(name, 20, new bi(this, new SpannableStringBuilder(name), this.cwi.getSelectionStart(), uD), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        Bitmap mz = aVar.mz();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(mz);
        int width = mz.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            width = (int) (0.5d * width);
        }
        bitmapDrawable.setBounds(0, 0, width, width);
        bitmapDrawable.setGravity(119);
        spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
        this.cwi.getText().insert(i, spannableStringBuilder);
    }

    public void arB() {
        this.cwi.onKeyDown(67, this.cxY);
    }

    private void f(Boolean bool) {
        String str = null;
        if (this.cqk != null) {
            str = this.cqk.getForumName();
        }
        if (getPageContext().getString(com.baidu.tieba.y.feedback_bar_name).equals(str)) {
            this.cxS = true;
        }
    }

    private void arC() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void arD() {
        try {
            if (this.cya != null) {
                this.cya.dismiss();
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

    private Boolean arE() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.bIf = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void aqP() {
        String str = null;
        if (this.cqk.getType() == 0) {
            String trim = this.cwe.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                this.mPrefixData.getPrefixs();
                if (this.cvN == 0) {
                    if (TextUtils.isEmpty(trim)) {
                        this.cqk.setIsNoTitle(true);
                    } else {
                        this.cqk.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.cqk.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.cqk.setIsNoTitle(true);
            } else {
                this.cqk.setIsNoTitle(false);
                str = "1";
            }
        }
        String trim2 = this.cwi.getText().toString().trim();
        if (this.cmP.alT()) {
            str = "1";
        } else if (!TextUtils.isEmpty(trim2)) {
            str = "1";
        } else if (this.cmP.alV()) {
            str = "1";
        } else if (this.cmP.alU()) {
            str = "1";
        }
        if (str == null || str.length() <= 0) {
            this.cwj.setEnabled(false);
        } else {
            this.cwj.setEnabled(true);
        }
    }

    private void initData(Bundle bundle) {
        this.aHK = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aHK.a(this.bIy);
        registerListener(this.cyr);
        this.ccP = new bj(this);
        this.cqk = new WriteData();
        if (bundle != null) {
            this.cqk.setType(bundle.getInt("type", 0));
            this.cqk.setForumId(bundle.getString("forum_id"));
            this.cqk.setForumName(bundle.getString("forum_name"));
            this.cqk.setThreadId(bundle.getString("thread_id"));
            this.cqk.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.cqk.setFloorNum(bundle.getInt(WriteActivityConfig.FLOOR_NUM, 0));
            this.cxS = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.cyb = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.cyc = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.baobaoImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.BAOBAO_IMAGES);
            this.aHI = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.cyh = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.cqk.setIsAddition(this.cyh != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.cym = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
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
                this.cqk.setLiveCardData(liveCardData);
            }
        } else {
            Intent intent = getIntent();
            this.cqk.setType(intent.getIntExtra("type", 0));
            this.cqk.setForumId(intent.getStringExtra("forum_id"));
            this.cqk.setForumName(intent.getStringExtra("forum_name"));
            this.cqk.setThreadId(intent.getStringExtra("thread_id"));
            this.cqk.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.cqk.setFloorNum(intent.getIntExtra(WriteActivityConfig.FLOOR_NUM, 0));
            this.cxS = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.cyb = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.cyc = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.cyh = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.cqk.setIsAddition(this.cyh != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.cym = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
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
                this.cqk.setLiveCardData(liveCardData2);
            }
        }
        this.baobaoImagesInfo.setMaxImagesAllowed(1);
        this.writeImagesInfo.setMaxImagesAllowed(10);
        this.cqk.setWriteImagesInfo(this.writeImagesInfo);
        this.cqk.setBaobaoImagesInfo(this.baobaoImagesInfo);
        if (this.cqk.getType() == 0) {
            if (this.cqk.getLiveCardData() == null) {
                com.baidu.tieba.tbadkCore.ao.b(this.cqk.getForumId(), this);
            } else {
                com.baidu.tieba.tbadkCore.ao.a(this.cqk.getLiveCardData().getGroupId(), this);
            }
        } else if (this.cqk.getType() == 1) {
            com.baidu.tieba.tbadkCore.ao.a(this.cqk.getThreadId(), this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(com.baidu.tieba.y.write_no_prefix));
        }
        this.bAb = TbadkCoreApplication.m411getInst().getDefaultBubble();
        if (this.cqk != null && this.cqk.getForumName() != null && TbadkCoreApplication.m411getInst().getYijianfankuiFname() != null && this.cqk.getForumName().equals(TbadkCoreApplication.m411getInst().getYijianfankuiFname())) {
            this.cxT = true;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ap
    public void a(WriteData writeData) {
        if (writeData != null && this.cqk != null) {
            this.cqk.setHaveDraft(true);
            if (com.baidu.adp.lib.util.m.isEmpty(this.cwe.getText().toString()) || ((this.cxS || this.cxT) && !com.baidu.adp.lib.util.m.isEmpty(writeData.getTitle()))) {
                this.cqk.setTitle(writeData.getTitle());
                this.cwe.setText(this.cqk.getTitle());
                this.cwe.setSelection(this.cqk.getTitle().length());
            }
            if (writeData.getLiveCardData() != null) {
                Date date = new Date(writeData.getLiveCardData().getStartTime() * 1000);
                Date date2 = new Date();
                date.setYear(date2.getYear());
                date.setMonth(date2.getMonth());
                date.setDate(date2.getDate());
                this.cqk.getLiveCardData().setStartTime(date.getTime() / 1000);
                this.cyo.setText(com.baidu.tbadk.core.util.bd.o(this.cqk.getLiveCardData().getStartTime() * 1000));
            }
            if ((com.baidu.adp.lib.util.m.isEmpty(this.cwi.getText().toString()) || this.cxS || this.cxT) && !com.baidu.adp.lib.util.m.isEmpty(writeData.getContent())) {
                this.cqk.setContent(writeData.getContent());
                SpannableString a = TbFaceManager.zx().a(getPageContext().getPageActivity(), this.cqk.getContent(), new bk(this));
                this.cwi.setText(a);
                this.cwi.setSelection(a.length());
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo = writeData.getWriteImagesInfo();
                this.cqk.setWriteImagesInfo(this.writeImagesInfo);
                this.cmP.a(this.writeImagesInfo, true);
                fk(false);
            }
            if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen()) {
                if (writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                    this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                    this.cqk.setIsBaobao(writeData.getIsBaobao());
                    this.cqk.setBaobaoContent(writeData.getBaobaoContent());
                    this.cqk.setBaobaoImagesInfo(this.baobaoImagesInfo);
                }
                if (this.cqk.getIsBaobao()) {
                    this.cmP.setBaobaoUris(this.baobaoImagesInfo);
                    fl(false);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.cqk.getType());
        bundle.putString("forum_id", this.cqk.getForumId());
        bundle.putString("forum_name", this.cqk.getForumName());
        bundle.putString("thread_id", this.cqk.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.cqk.getFloor());
        bundle.putInt(WriteActivityConfig.FLOOR_NUM, this.cqk.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.cyb);
        if (this.cxS) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putSerializable(WriteActivityConfig.BAOBAO_IMAGES, this.baobaoImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aHI);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.cyh);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.cym);
        if (this.cqk.getLiveCardData() != null) {
            bundle.putBoolean(WriteActivityConfig.IS_LIVE_POST, true);
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ID, this.cqk.getLiveCardData().getGroupId());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_HEAD, this.cqk.getLiveCardData().getPortrait());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_INTRO, this.cqk.getLiveCardData().getIntro());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_NAME, this.cqk.getLiveCardData().getName());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_MEMBER_COUNT, this.cqk.getLiveCardData().getListeners());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ZAN_COUNT, this.cqk.getLiveCardData().getLikers());
            bundle.putLong(WriteActivityConfig.LIVE_DATE, this.cqk.getLiveCardData().getStartTime());
            bundle.putBoolean(WriteActivityConfig.LIVE_TIME_IS_MODIFY, this.cqk.getLiveCardData().isModifyTime());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_PUBLISH_HEAD, this.cqk.getLiveCardData().getPublisherPortrait());
        }
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = this.cwi.getEditableText().toString();
        if (editable != null) {
            this.cwi.setText(TbFaceManager.zx().E(getPageContext().getPageActivity(), editable));
            this.cwi.setSelection(this.cwi.getText().length());
        }
    }

    public void aqK() {
        aqH();
        if (this.cqk.getLiveCardData() != null) {
            if (!this.cqk.getLiveCardData().isModifyTime()) {
                this.cqk.getLiveCardData().setStartTime(new Date().getTime() / 1000);
                this.cyo.setText(com.baidu.tbadk.core.util.bd.o(this.cqk.getLiveCardData().getStartTime() * 1000));
            }
            long time = new Date().getTime() / TbConfig.USE_TIME_INTERVAL;
            Date date = new Date(this.cqk.getLiveCardData().getStartTime() * 1000);
            Date date2 = new Date();
            date.setYear(date2.getYear());
            date.setMonth(date2.getMonth());
            date.setDate(date2.getDate());
            this.cqk.getLiveCardData().setStartTime(date.getTime() / 1000);
            if (time > this.cqk.getLiveCardData().getStartTime() / 60) {
                showToast(com.baidu.tieba.y.live_start_time_error);
                return;
            }
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.cvN != 0) {
            this.cqk.setTitle(String.valueOf(this.cwk.getText().toString()) + this.cwe.getText().toString());
        } else {
            this.cqk.setTitle(this.cwe.getText().toString());
        }
        this.cqk.setContent(this.cwi.getText().toString());
        if (this.cxS || this.cxT) {
            String string = getResources().getString(com.baidu.tieba.y.android_feedback);
            if (TextUtils.isEmpty(this.cqk.getTitle()) || !this.cqk.getTitle().startsWith(string)) {
                this.cqk.setTitle(string + this.cqk.getTitle());
            }
            String str = String.valueOf(getResources().getString(com.baidu.tieba.y.app_name)) + getResources().getString(com.baidu.tieba.y.tieba_client);
            if (TextUtils.isEmpty(this.cqk.getContent()) || !this.cqk.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.k.iH()) {
                    sb.append(com.baidu.adp.lib.util.k.iO());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.cqk.getContent());
                this.cqk.setContent(sb.toString());
            }
        }
        this.cqk.setWriteImagesInfo(this.writeImagesInfo);
        this.cqk.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.cqk.setHasLocationData(this.cye.getLocationInfoViewState() == 2);
        this.aHK.eQ(this.writeImagesInfo.size() > 0);
        this.aHK.c(this.cqk);
        VoiceData.VoiceModel audioData = this.cmP.getAudioData();
        this.cmP.Jn();
        this.cqk.setVcode(null);
        if (audioData != null) {
            if (audioData.getId() != null) {
                this.aHK.IS().setVoice(audioData.getId());
                this.aHK.IS().setVoiceDuringTime(audioData.duration);
            } else {
                this.aHK.IS().setVoice(null);
                this.aHK.IS().setVoiceDuringTime(-1);
            }
        } else {
            this.aHK.IS().setVoice(null);
            this.aHK.IS().setVoiceDuringTime(-1);
        }
        if (!this.aHK.anR()) {
            showToast(com.baidu.tieba.y.write_img_limit);
        } else if (this.aHK.anP()) {
            showLoadingDialog(getPageContext().getString(com.baidu.tieba.y.sending), this.ccP);
        }
    }

    private void l(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.cyh != null) {
                i2 = this.cyh.getTotalCount();
                i = this.cyh.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(com.baidu.tieba.y.write_addition_left_count), Integer.valueOf(i2 - i)));
            }
        }
        com.baidu.adp.lib.util.n.showToast(getPageContext().getPageActivity(), sb.toString());
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12004) {
                ArrayList<String> V = com.baidu.tieba.tbadkCore.util.i.V(intent);
                if (V != null && V.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < V.size()) {
                            sb.append("@");
                            sb.append(V.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            String sb2 = sb.toString();
                            this.cwi.getText().insert(this.cwi.getSelectionStart(), sb2);
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                if (this.cqk.getType() == 0) {
                    com.baidu.tieba.tbadkCore.ao.a(this.cqk.getForumId(), (WriteData) null);
                } else if (this.cqk.getType() == 1) {
                    com.baidu.tieba.tbadkCore.ao.b(this.cqk.getThreadId(), (WriteData) null);
                }
                setResult(-1, intent);
                finish();
            } else if (i == 12002) {
                if (intent != null) {
                    if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                        aa(intent);
                    } else {
                        Z(intent);
                    }
                }
            } else if (i == 12012) {
                K(intent);
                aqP();
            } else if (i == 12013) {
                T(intent);
                aqP();
            } else if (i == 23004) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    IT();
                    return;
                case 12002:
                    if (!this.cmP.alT()) {
                        ary();
                    }
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                        return;
                    }
                    return;
                case 12009:
                    sendMessage(new CustomMessage(2002001, new JigsawAlbumActivityConfig(getPageContext().getPageActivity(), 12002)));
                    return;
                case 12010:
                    this.aHI = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.az.a(getPageContext(), this.aHI);
                    return;
                default:
                    return;
            }
        }
    }

    private void Z(Intent intent) {
        Q(intent);
        aqP();
        this.cmP.setVisibility(0);
    }

    private void aa(Intent intent) {
        int size;
        L(intent);
        int size2 = this.writeImagesInfo.size() - 1;
        if (size2 > -1 && this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size2)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.cwe);
        HidenSoftKeyPad(this.mInputManager, this.cwi);
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void Q(Intent intent) {
        b(intent, true);
    }

    public boolean arF() {
        boolean alV = this.cmP.alV();
        LinkedList<ImageFileInfo> chosedFiles = this.baobaoImagesInfo.getChosedFiles();
        return !alV && (chosedFiles == null || chosedFiles.isEmpty());
    }

    private void L(Intent intent) {
        this.aHI = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aHI;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cf = com.baidu.tbadk.core.util.c.cf(str);
                if (cf != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.n.M(getPageContext().getPageActivity())), com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.n.N(getPageContext().getPageActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.c.h(b, cf);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.o.a(TbConfig.LOCAL_CAMERA_DIR, this.aHI, h, 100);
                    h.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            this.cmP.a(this.writeImagesInfo, true);
        }
        fk(true);
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
                    this.cmP.a(this.writeImagesInfo, z);
                }
            }
            fk(true);
        }
    }

    private void T(Intent intent) {
        if (this.cqk != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(stringExtra);
            this.baobaoImagesInfo.clear();
            this.baobaoImagesInfo.addChooseFile(imageFileInfo);
            this.cqk.setIsBaobao(true);
            this.cqk.setBaobaoContent(stringExtra2);
            this.cmP.setBaobaoUris(this.baobaoImagesInfo);
            fl(true);
        }
    }

    private void IT() {
        new bl(this).execute(new Void[0]);
    }

    private void fk(boolean z) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() > 0) {
            this.cyf.el(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            this.cyg = true;
            this.cmP.el(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            if (this.cmP.alK() || z) {
                this.cmP.alQ();
                return;
            }
            return;
        }
        this.cyf.yV();
        this.cyg = false;
        this.cmP.yV();
        if (this.cmP.alV()) {
            this.cmP.zd();
            this.cyf.amr();
        }
        ary();
    }

    private void fl(boolean z) {
        LinkedList<ImageFileInfo> chosedFiles = this.baobaoImagesInfo.getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() > 0) {
            this.cyf.aqs();
            this.cyf.amr();
            if (this.cmP.alK() || z) {
                this.cmP.alS();
            }
            this.cqk.setIsBaobao(true);
            return;
        }
        if (arF()) {
            this.cyf.ams();
        }
        this.cqk.setIsBaobao(false);
        this.cyf.aqr();
        ary();
    }

    @Override // com.baidu.tbadk.core.voice.j
    public synchronized VoiceManager getVoiceManager() {
        if (this.mVoiceManager == null) {
            this.mVoiceManager = VoiceManager.instance();
        }
        return this.mVoiceManager;
    }

    @Override // com.baidu.tbadk.core.voice.j
    public com.baidu.tbadk.core.voice.i getRealView(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public synchronized void stopVoice() {
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.stopPlay();
    }

    public void a(boolean z, AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        String str = "";
        if (postWriteCallBackData != null) {
            str = postWriteCallBackData.getErrorString();
        }
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.cqk.getForumName());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.WRITE);
        } else if (this.cyh == null) {
            com.baidu.tieba.tbadkCore.writeModel.h.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        } else {
            l(z, str);
        }
    }

    public void a(boolean z, AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.cqk.getForumName());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.WRITE);
        } else if (this.cyh == null) {
            com.baidu.tieba.tbadkCore.writeModel.h.L(getPageContext().getPageActivity(), str);
        } else {
            l(z, str);
        }
    }

    private void jk(int i) {
        if (i < this.cxX.size()) {
            for (int i2 = 0; i2 < this.cxX.size(); i2++) {
                this.cxX.get(i2).fh(false);
            }
            this.cxX.get(i).fh(true);
        }
    }

    @Override // com.baidu.tieba.write.write.cn
    public void iZ(int i) {
        this.cvN = i;
        this.cwl.setCurrentIndex(i);
        jk(i);
        this.cwk.setText(this.mPrefixData.getPrefixs().get(i));
        aqP();
        com.baidu.adp.lib.g.k.a(this.cwl, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.cwn.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
