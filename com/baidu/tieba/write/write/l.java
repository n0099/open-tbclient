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
import com.baidu.adp.lib.c.a;
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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
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
public class l {
    private static final Pattern ofk = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext eNx;
    public com.baidu.tieba.write.c jYx;
    public String mLat;
    public String mLng;
    private WriteUrlModel ofg;
    private m ofl;
    private com.baidu.tieba.write.model.a ofm;
    private com.baidu.tieba.write.transmit.model.a ofn;
    private com.baidu.tbadk.core.view.a ofo;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == R.id.icon_invoke_link) {
                    l.this.ebX();
                    TiebaStatic.log(new ar("c12169"));
                }
                if (view.getId() == R.id.url_edit_back_view) {
                    l.this.ebW();
                }
            }
        }
    };
    private View.OnClickListener ofp = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.l.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == R.id.url_add) {
                TiebaStatic.log(new ar("c12163"));
                String eck = l.this.ofl.eck();
                if (l.ofk.matcher(eck).matches()) {
                    l.this.ebW();
                    l.this.ofm.VI(eck);
                    l.this.ofl.a(null, true);
                    return;
                }
                TiebaStatic.log(new ar("c12164"));
                l.this.ofl.ecl();
            }
        }
    };
    private TextWatcher ofq = new TextWatcher() { // from class: com.baidu.tieba.write.write.l.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            l.this.ofl.ecc();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (l.this.jYx != null) {
                if (!l.this.jYx.dYq()) {
                    l.this.zp(false);
                }
                l.this.jYx.zc(false);
            }
        }
    };
    private DialogInterface.OnCancelListener ofr = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.l.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (l.this.ofn != null) {
                l.this.ofn.cFh();
            }
        }
    };
    private a.InterfaceC0899a nTy = new a.InterfaceC0899a() { // from class: com.baidu.tieba.write.write.l.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0899a
        public void onError() {
            l.this.gw(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0899a
        public void t(List<SimpleForum> list, int i) {
            l.this.gw(list);
        }
    };
    private a.InterfaceC0020a gAr = new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.write.l.6
        @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                l.this.mLat = String.valueOf(address.getLatitude());
                l.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d fwI = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.l.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            l.this.ofl.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                l.this.jYx.bn(null);
                l.this.jYx.zb(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (l.this.g(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.h(l.this.eNx.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    l.this.eNx.getPageActivity().setResult(-1, intent);
                    l.this.eNx.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    l.this.eNx.showToast(postWriteCallBackData.getErrorString());
                    l.this.jYx.bn(postWriteCallBackData.getSensitiveWords());
                    l.this.jYx.VA(postWriteCallBackData.getErrorString());
                    if (!y.isEmpty(l.this.jYx.dYn())) {
                        l.this.zp(true);
                    }
                } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    l.this.ofl.n(postWriteCallBackData);
                } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bxM());
                    if (!com.baidu.tbadk.t.a.ES(ahVar.bxL())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(l.this.eNx.getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(l.this.eNx.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bxL())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(l.this.eNx.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public l(TbPageContext tbPageContext, m mVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.ofo = null;
        this.eNx = tbPageContext;
        this.ofl = mVar;
        this.ofm = aVar;
        this.ofg = writeUrlModel;
        this.ofl.an(this.mClickListener);
        this.ofl.ao(this.ofp);
        this.ofl.e(this.ofq);
        ebX();
        this.ofo = new com.baidu.tbadk.core.view.a(this.eNx);
        this.ofo.setCancelListener(this.ofr);
        ebV();
        this.ofg.b(this.fwI);
        this.jYx = new com.baidu.tieba.write.c();
        this.jYx.MB(R.color.CAM_X0101);
        this.jYx.MC(R.color.cp_cont_h_alpha85);
    }

    private void ebV() {
        this.ofn = new com.baidu.tieba.write.transmit.model.a(this.eNx.getUniqueId());
        this.ofn.a(this.nTy);
        if (this.ofg.dcE() != null) {
            this.ofn.setForumId(this.ofg.dcE().getForumId());
        }
    }

    protected void ebW() {
        this.ofl.ecj();
    }

    protected void ebX() {
        this.ofl.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gw(List<SimpleForum> list) {
        WriteData dcE = this.ofg.dcE();
        if (dcE != null) {
            this.ofo.setDialogVisiable(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(dcE.getForumId()) && !dcE.getForumId().equals("0") && !StringUtils.isNull(dcE.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.f.b.toLong(dcE.getForumId(), 0L), dcE.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (y.getCount(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.f.b.toLong(dcE.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.eNx.getPageActivity(), RequestResponseCode.REQUEST_SELECT_TRANSMIT_FORUM);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void dPX() {
        if (ae.checkLocationForBaiduLocation(this.eNx.getPageActivity())) {
            com.baidu.adp.lib.c.a.mk().a(true, this.gAr);
        }
    }

    public void destroy() {
        if (this.ofn != null) {
            this.ofn.destroy();
        }
        if (this.ofm != null) {
            this.ofm.destroy();
        }
        if (this.ofg != null) {
            this.ofg.cancelLoadData();
        }
    }

    public void cti() {
        this.ofn.setThreadContent(this.ofl.ecd());
        this.ofn.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zp(boolean z) {
        if (this.ofl.ecf() != null && this.ofl.ecd() != null) {
            int selectionEnd = this.ofl.ecf().getSelectionEnd();
            SpannableStringBuilder c = this.jYx.c(this.ofl.ecf().getText());
            if (c != null) {
                this.jYx.zc(true);
                this.ofl.ecf().setText(c);
                if (z && this.jYx.dYo() >= 0) {
                    this.ofl.ecf().requestFocus();
                    this.ofl.ecf().setSelection(this.jYx.dYo());
                } else {
                    this.ofl.ecf().setSelection(selectionEnd);
                }
                this.jYx.zb(this.jYx.dYo() >= 0);
            }
        }
    }

    public boolean ebY() {
        if (this.jYx.dYp()) {
            this.eNx.showToast(this.jYx.dYr());
            zp(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.jYx.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData dcE;
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
                    this.eNx.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (dcE = this.ofg.dcE()) != null && this.ofm.dZf() != null) {
                if (intent != null) {
                    dcE.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                dcE.setForumId("0");
                dcE.setCanNoForum(true);
                dcE.setRecommendExt(this.ofn.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    ebZ();
                } else if (ae.checkLocationForBaiduLocation(this.eNx.getPageActivity())) {
                    com.baidu.adp.lib.c.a.mk().a(true, new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.write.l.8
                        @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
                        public void onLocationGeted(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                l.this.mLat = String.valueOf(address.getLatitude());
                                l.this.mLng = String.valueOf(address.getLongitude());
                            }
                            l.this.ebZ();
                        }
                    });
                }
                this.ofl.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.eNx.showToast(postWriteCallBackData.getErrorString());
                        this.jYx.bn(postWriteCallBackData.getSensitiveWords());
                        if (!y.isEmpty(this.jYx.dYn())) {
                            zp(true);
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

    public void ebZ() {
        this.ofg.h("", this.ofl.ecd(), this.ofm.dZf().linkUrl, this.ofm.dZf().linkUrlCode, this.mLat, this.mLng);
    }
}
