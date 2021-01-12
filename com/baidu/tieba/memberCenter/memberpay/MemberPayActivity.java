package com.baidu.tieba.memberCenter.memberpay;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.pay.PayConfigModel;
import com.baidu.tbadk.pay.ResponseGetPayinfoMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class MemberPayActivity extends BaseActivity<MemberPayActivity> implements RadioGroup.OnCheckedChangeListener {
    private String lgA;
    private MemberPayView lgB;
    private int lgC;
    private PayConfigModel lgE;
    private int lgy;
    private int lgz;
    private String mClickZone;
    private int mFrom;
    private boolean mIsClose;
    private String mReferPage;
    private String mStType;
    private static String lgI = "https://tieba.baidu.com/tb/eula_mobile.html?";
    private static String lgf = "https://tieba.baidu.com/tb/vip_eula_mobile.html";
    private static String lgJ = "https://tieba.baidu.com/tb/viprenew_eula_mobile.html";
    private boolean lgD = false;
    private Boolean lgF = false;
    private String lgG = "c10482";
    private String lgH = "c10483";
    private HttpMessageListener lgK = new HttpMessageListener(1001505) { // from class: com.baidu.tieba.memberCenter.memberpay.MemberPayActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505 && (httpResponsedMessage instanceof ResponseGetPayinfoMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0) {
                    ResponseGetPayinfoMessage responseGetPayinfoMessage = (ResponseGetPayinfoMessage) httpResponsedMessage;
                    if (responseGetPayinfoMessage.getPayInfoResultData() != null) {
                        int pay_status = responseGetPayinfoMessage.getPayInfoResultData().getPay_status();
                        if (pay_status == 0) {
                            MemberPayActivity.this.ddv();
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_RESPONSE_MEM, Integer.valueOf(MemberPayActivity.this.lgC)));
                            MemberPayActivity.this.setResult(-1);
                            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, true);
                            if (MemberPayActivity.this.mIsClose) {
                                MemberPayActivity.this.closeActivity();
                                return;
                            } else {
                                MemberPayActivity.this.ddk();
                                return;
                            }
                        }
                        if (pay_status == 1 || pay_status == 3) {
                        }
                    }
                }
            }
        }
    };
    public HttpMessageListener lgj = new HttpMessageListener(1001532) { // from class: com.baidu.tieba.memberCenter.memberpay.MemberPayActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            MemberPayActivity.this.closeLoadingDialog();
            if ((httpResponsedMessage instanceof ResponseMemberPayMessage) && httpResponsedMessage.getCmd() == 1001532) {
                ResponseMemberPayMessage responseMemberPayMessage = (ResponseMemberPayMessage) httpResponsedMessage;
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    String errorString = responseMemberPayMessage.getErrorString();
                    if (StringUtils.isNull(errorString)) {
                        errorString = MemberPayActivity.this.getResources().getString(R.string.neterror);
                    }
                    MemberPayActivity.this.showToast(errorString);
                } else if (responseMemberPayMessage.getMemberPayResult() != null) {
                    MemberPayActivity.this.lgB.setDataAndRefreshUI(responseMemberPayMessage.getMemberPayResult());
                    MemberPayActivity.this.lgD = true;
                } else {
                    MemberPayActivity.this.showToast(R.string.neterror);
                }
            }
        }
    };
    final CustomMessageListener lgL = new CustomMessageListener(CmdConfigCustom.CMD_AUTO_PAY_SUCC) { // from class: com.baidu.tieba.memberCenter.memberpay.MemberPayActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016525 && MemberPayActivity.this.lgB != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                MemberPayActivity.this.lgB.tH(((Boolean) customResponsedMessage.getData()).booleanValue());
                MemberPayActivity.this.showToast(R.string.tips_auto_pay_succ);
            }
        }
    };
    NoNetworkView.a gvp = new NoNetworkView.a() { // from class: com.baidu.tieba.memberCenter.memberpay.MemberPayActivity.5
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && !MemberPayActivity.this.lgD) {
                MemberPayActivity.this.ddk();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaStatic.log(this.lgG);
        if (!TbadkCoreApplication.isLogin()) {
            bg.skipToLoginActivity(getActivity());
            finish();
            return;
        }
        ddt();
        t consumePathData = TbadkCoreApplication.getInst().getConsumePathData();
        if (consumePathData != null) {
            this.lgF = Boolean.valueOf(consumePathData.aI(1, this.lgA));
        }
        initView();
        initListener();
        initData();
        ddu();
    }

    private void ddt() {
        if (getIntent() != null && getIntent().getExtras() != null) {
            this.lgy = getIntent().getExtras().getInt("member_type");
            this.mStType = getIntent().getExtras().getString("st_type");
            this.mFrom = getIntent().getExtras().getInt("from", 0);
            this.mIsClose = getIntent().getExtras().getBoolean("close");
            this.lgz = getIntent().getExtras().getInt("from_scene", 0);
            this.lgA = getIntent().getExtras().getString("scene_id");
        }
        if (this.lgz == 3) {
            this.lgA = "4001001001";
        } else if (this.lgz == 4) {
            this.lgA = "4001001002";
        }
        if (StringUtils.isNull(this.lgA)) {
            this.lgA = "4008001000";
        }
        this.mReferPage = getIntent().getExtras().getString("refer_page");
        this.mClickZone = getIntent().getExtras().getString("click_zone");
    }

    private void initView() {
        showLoadingDialog(getPageContext().getString(R.string.flist_loading));
        this.lgB = new MemberPayView(this, this.lgy, this.lgF.booleanValue());
    }

    private void initListener() {
        registerListener(this.lgj);
        registerListener(this.lgK);
        registerListener(this.lgL);
        if (this.lgB != null && this.lgB.getNoNetworkView() != null) {
            this.lgB.getNoNetworkView().a(this.gvp);
        }
    }

    private void initData() {
        ddj();
        this.lgE = new PayConfigModel(this, new com.baidu.tbadk.pay.a() { // from class: com.baidu.tieba.memberCenter.memberpay.MemberPayActivity.4
            @Override // com.baidu.tbadk.pay.a
            public void onError(String str) {
                MemberPayActivity.this.ddk();
            }

            @Override // com.baidu.tbadk.pay.a
            public void onPayNative() {
                MemberPayActivity.this.ddk();
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.memberCenter.memberpay.MemberPayActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.pay.a
            public void onPayH5() {
                com.baidu.tbadk.pay.c.bDD().a("http://tieba.baidu.com/mo/q/tbeantshow?refer_page=" + MemberPayActivity.this.mReferPage + "&click_zone=" + MemberPayActivity.this.mClickZone, MemberPayActivity.this.getPageContext());
                MemberPayActivity.this.finish();
            }
        });
        this.lgE.bDC();
    }

    private void ddj() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001532, TbConfig.SERVER_ADDRESS + TbConfig.MEMBER_PAY);
        tbHttpMessageTask.setResponsedClass(ResponseMemberPayMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddk() {
        HttpMessage httpMessage = new HttpMessage(1001532);
        if (this.mStType != null) {
            httpMessage.addParam("st_type", this.mStType);
        }
        httpMessage.addParam("from_scene", this.lgz);
        sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.lgB != null && this.lgB.getNoNetworkView() != null) {
            this.lgB.getNoNetworkView().b(this.gvp);
        }
        if (this.lgE != null) {
            this.lgE.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lgB != null) {
            this.lgB.onChangeSkinType(i);
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (this.lgB != null) {
            if (i == R.id.btn_mem1) {
                this.lgB.Ek(2);
            } else if (i == R.id.btn_mem2) {
                this.lgB.Ek(1);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == R.id.aotu_pay_law) {
            be.bsB().b(getPageContext(), new String[]{lgI + TbadkCoreApplication.getCurrentVerson(getPageContext().getPageActivity())});
        }
        if (view.getId() == R.id.tv_member_agreement_normal || view.getId() == R.id.tv_member_agreement_auto_pay) {
            be.bsB().b(getPageContext(), new String[]{lgf});
        }
        if (view.getId() == R.id.tv_auto_pay_agreement_auto_pay) {
            be.bsB().b(getPageContext(), new String[]{lgJ});
        }
    }

    private void ddu() {
        if (this.mFrom == 6) {
            TiebaStatic.log("consume_24");
        } else if (this.mFrom == 2) {
            TiebaStatic.log(TbadkCoreStatisticKey.FRS_EXPERIENCE_SPEED);
        } else if (this.mFrom == 4) {
            TiebaStatic.log("c10751");
        } else if (this.mFrom == 5) {
            TiebaStatic.log("c10750");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddv() {
        if (this.mFrom == 2) {
            Nm("consume_10");
        } else if (this.mFrom == 1) {
            Nm("consume_5");
        } else if (this.mFrom == 3) {
            Nm("consume_35");
        } else if (this.mFrom == 4) {
            TiebaStatic.log("c10032");
        } else if (this.mFrom == 5) {
            TiebaStatic.log("c10039");
        } else if (this.mFrom == 6) {
            TiebaStatic.log(TbadkCoreStatisticKey.TAIL_PAY_MEMBER_SUCCESS);
        } else if (this.mFrom == 7) {
            TiebaStatic.log(TbadkCoreStatisticKey.BUBBLE_PAY_MEMBER_SUCCESS);
        }
    }

    private void Nm(String str) {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), str, "click");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.MEMBER_BUY;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.isRouteStat = true;
        }
        return pageStayDurationItem;
    }

    public int getFrom() {
        return this.mFrom;
    }

    public String getReferPage() {
        return this.mReferPage;
    }

    public String getClickZone() {
        return this.mClickZone;
    }
}
