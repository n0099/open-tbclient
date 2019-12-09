package com.baidu.tieba.write.write;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.transmit.TransmitForumActivityConfig;
import com.baidu.tieba.write.transmit.model.a;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import tbclient.SimpleForum;
/* loaded from: classes3.dex */
public class j {
    private static final Pattern jVB = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext ceu;
    public com.baidu.tieba.write.b gnK;
    private k jVC;
    private com.baidu.tieba.write.model.a jVD;
    private com.baidu.tieba.write.transmit.model.a jVE;
    private com.baidu.tbadk.core.view.b jVF;
    private WriteUrlModel jVx;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == R.id.icon_invoke_link) {
                    j.this.cAt();
                    TiebaStatic.log(new an("c12169"));
                }
                if (view.getId() == R.id.url_edit_back_view) {
                    j.this.cAs();
                }
            }
        }
    };
    private View.OnClickListener jVG = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == R.id.url_add) {
                TiebaStatic.log(new an("c12163"));
                String cAG = j.this.jVC.cAG();
                if (j.jVB.matcher(cAG).matches()) {
                    j.this.cAs();
                    j.this.jVD.FC(cAG);
                    j.this.jVC.a(null, true);
                    return;
                }
                TiebaStatic.log(new an("c12164"));
                j.this.jVC.cAH();
            }
        }
    };
    private TextWatcher jVH = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.jVC.cAy();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.gnK != null) {
                if (!j.this.gnK.cxz()) {
                    j.this.rS(false);
                }
                j.this.gnK.rL(false);
            }
        }
    };
    private DialogInterface.OnCancelListener jVI = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.jVE != null) {
                j.this.jVE.bmt();
            }
        }
    };
    private a.InterfaceC0536a jLW = new a.InterfaceC0536a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0536a
        public void onError() {
            j.this.eP(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0536a
        public void d(List<SimpleForum> list, int i) {
            j.this.eP(list);
        }
    };
    private a.InterfaceC0015a dDK = new a.InterfaceC0015a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d cGo = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            j.this.jVC.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.gnK.aM(null);
                j.this.gnK.rK(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (j.this.e(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.g(j.this.ceu.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    j.this.ceu.getPageActivity().setResult(-1, intent);
                    j.this.ceu.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    j.this.ceu.showToast(postWriteCallBackData.getErrorString());
                    j.this.gnK.aM(postWriteCallBackData.getSensitiveWords());
                    j.this.gnK.Fv(postWriteCallBackData.getErrorString());
                    if (!v.isEmpty(j.this.gnK.cxw())) {
                        j.this.rS(true);
                    }
                } else if ((yVar == null || writeData == null || yVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.jVC.l(postWriteCallBackData);
                } else if (yVar != null && writeData != null && yVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(yVar.getVcode_md5());
                    writeData.setVcodeUrl(yVar.getVcode_pic_url());
                    writeData.setVcodeExtra(yVar.aps());
                    if (!com.baidu.tbadk.v.a.qv(yVar.apr())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(j.this.ceu.getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(j.this.ceu.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, yVar.apr())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(j.this.ceu.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.jVF = null;
        this.ceu = tbPageContext;
        this.jVC = kVar;
        this.jVD = aVar;
        this.jVx = writeUrlModel;
        this.jVC.af(this.mClickListener);
        this.jVC.ag(this.jVG);
        this.jVC.g(this.jVH);
        cAt();
        this.jVF = new com.baidu.tbadk.core.view.b(this.ceu);
        this.jVF.setCancelListener(this.jVI);
        cAr();
        this.jVx.b(this.cGo);
        this.gnK = new com.baidu.tieba.write.b();
        this.gnK.Br(R.color.cp_cont_a);
        this.gnK.Bs(R.color.cp_cont_h_alpha85);
    }

    private void cAr() {
        this.jVE = new com.baidu.tieba.write.transmit.model.a(this.ceu.getUniqueId());
        this.jVE.a(this.jLW);
        if (this.jVx.cla() != null) {
            this.jVE.setForumId(this.jVx.cla().getForumId());
        }
    }

    protected void cAs() {
        this.jVC.cAF();
    }

    protected void cAt() {
        this.jVC.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eP(List<SimpleForum> list) {
        WriteData cla = this.jVx.cla();
        if (cla != null) {
            this.jVF.setDialogVisiable(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(cla.getForumId()) && !cla.getForumId().equals("0") && !StringUtils.isNull(cla.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.toLong(cla.getForumId(), 0L), cla.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.getCount(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.toLong(cla.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.ceu.getPageActivity(), RequestResponseCode.REQUEST_SELECT_TRANSMIT_FORUM);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void coX() {
        if (ab.checkLocationForBaiduLocation(this.ceu.getPageActivity())) {
            com.baidu.adp.lib.d.a.fw().a(true, this.dDK);
        }
    }

    public void destroy() {
        if (this.jVE != null) {
            this.jVE.destroy();
        }
        if (this.jVD != null) {
            this.jVD.destroy();
        }
        if (this.jVx != null) {
            this.jVx.cancelLoadData();
        }
    }

    public void bca() {
        this.jVE.setThreadContent(this.jVC.cAz());
        this.jVE.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rS(boolean z) {
        if (this.jVC.cAB() != null && this.jVC.cAz() != null) {
            int selectionEnd = this.jVC.cAB().getSelectionEnd();
            SpannableStringBuilder a = this.gnK.a(this.jVC.cAB().getText());
            if (a != null) {
                this.gnK.rL(true);
                this.jVC.cAB().setText(a);
                if (z && this.gnK.cxx() >= 0) {
                    this.jVC.cAB().requestFocus();
                    this.jVC.cAB().setSelection(this.gnK.cxx());
                } else {
                    this.jVC.cAB().setSelection(selectionEnd);
                }
                this.gnK.rK(this.gnK.cxx() >= 0);
            }
        }
    }

    public boolean cAu() {
        if (this.gnK.cxy()) {
            this.ceu.showToast(this.gnK.cxA());
            rS(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.gnK.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData cla;
        if (i2 == -1) {
            if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = null;
                if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) {
                    postWriteCallBackData2 = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                }
                if (postWriteCallBackData2 != null) {
                    Intent intent2 = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData2);
                    intent2.putExtras(bundle);
                    this.ceu.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (cla = this.jVx.cla()) != null && this.jVD.cyv() != null) {
                if (intent != null) {
                    cla.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                cla.setForumId("0");
                cla.setCanNoForum(true);
                cla.setRecommendExt(this.jVE.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    cAv();
                } else if (ab.checkLocationForBaiduLocation(this.ceu.getPageActivity())) {
                    com.baidu.adp.lib.d.a.fw().a(true, new a.InterfaceC0015a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
                        public void onLocationGeted(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.cAv();
                        }
                    });
                }
                this.jVC.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.ceu.showToast(postWriteCallBackData.getErrorString());
                        this.gnK.aM(postWriteCallBackData.getSensitiveWords());
                        if (!v.isEmpty(this.gnK.cxw())) {
                            rS(true);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void cAv() {
        this.jVx.e("", this.jVC.cAz(), this.jVD.cyv().linkUrl, this.jVD.cyv().linkUrlCode, this.mLat, this.mLng);
    }
}
