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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ad;
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
/* loaded from: classes2.dex */
public class j {
    private static final Pattern mvP = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext dPv;
    public com.baidu.tieba.write.c iyU;
    public String mLat;
    public String mLng;
    private WriteUrlModel mvL;
    private k mvQ;
    private com.baidu.tieba.write.model.a mvR;
    private com.baidu.tieba.write.transmit.model.a mvS;
    private com.baidu.tbadk.core.view.a mvT;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == R.id.icon_invoke_link) {
                    j.this.dtY();
                    TiebaStatic.log(new ao("c12169"));
                }
                if (view.getId() == R.id.url_edit_back_view) {
                    j.this.dtX();
                }
            }
        }
    };
    private View.OnClickListener mvU = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == R.id.url_add) {
                TiebaStatic.log(new ao("c12163"));
                String dul = j.this.mvQ.dul();
                if (j.mvP.matcher(dul).matches()) {
                    j.this.dtX();
                    j.this.mvR.OV(dul);
                    j.this.mvQ.a(null, true);
                    return;
                }
                TiebaStatic.log(new ao("c12164"));
                j.this.mvQ.dum();
            }
        }
    };
    private TextWatcher mvV = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.mvQ.dud();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.iyU != null) {
                if (!j.this.iyU.dqP()) {
                    j.this.vR(false);
                }
                j.this.iyU.vF(false);
            }
        }
    };
    private DialogInterface.OnCancelListener mvW = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.mvS != null) {
                j.this.mvS.caS();
            }
        }
    };
    private a.InterfaceC0772a mlx = new a.InterfaceC0772a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0772a
        public void onError() {
            j.this.fn(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0772a
        public void h(List<SimpleForum> list, int i) {
            j.this.fn(list);
        }
    };
    private a.InterfaceC0020a fwz = new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d evL = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
            j.this.mvQ.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.iyU.aY(null);
                j.this.iyU.vE(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (j.this.e(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.f(j.this.dPv.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    j.this.dPv.getPageActivity().setResult(-1, intent);
                    j.this.dPv.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    j.this.dPv.showToast(postWriteCallBackData.getErrorString());
                    j.this.iyU.aY(postWriteCallBackData.getSensitiveWords());
                    j.this.iyU.ON(postWriteCallBackData.getErrorString());
                    if (!w.isEmpty(j.this.iyU.dqM())) {
                        j.this.vR(true);
                    }
                } else if ((adVar == null || writeData == null || adVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.mvQ.l(postWriteCallBackData);
                } else if (adVar != null && writeData != null && adVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(adVar.getVcode_md5());
                    writeData.setVcodeUrl(adVar.getVcode_pic_url());
                    writeData.setVcodeExtra(adVar.bas());
                    if (!com.baidu.tbadk.t.a.zq(adVar.bar())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(j.this.dPv.getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(j.this.dPv.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, adVar.bar())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(j.this.dPv.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.mvT = null;
        this.dPv = tbPageContext;
        this.mvQ = kVar;
        this.mvR = aVar;
        this.mvL = writeUrlModel;
        this.mvQ.ak(this.mClickListener);
        this.mvQ.al(this.mvU);
        this.mvQ.e(this.mvV);
        dtY();
        this.mvT = new com.baidu.tbadk.core.view.a(this.dPv);
        this.mvT.setCancelListener(this.mvW);
        dtW();
        this.mvL.b(this.evL);
        this.iyU = new com.baidu.tieba.write.c();
        this.iyU.Gz(R.color.cp_cont_a);
        this.iyU.GA(R.color.cp_cont_h_alpha85);
    }

    private void dtW() {
        this.mvS = new com.baidu.tieba.write.transmit.model.a(this.dPv.getUniqueId());
        this.mvS.a(this.mlx);
        if (this.mvL.dew() != null) {
            this.mvS.setForumId(this.mvL.dew().getForumId());
        }
    }

    protected void dtX() {
        this.mvQ.duk();
    }

    protected void dtY() {
        this.mvQ.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fn(List<SimpleForum> list) {
        WriteData dew = this.mvL.dew();
        if (dew != null) {
            this.mvT.setDialogVisiable(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(dew.getForumId()) && !dew.getForumId().equals("0") && !StringUtils.isNull(dew.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.f.b.toLong(dew.getForumId(), 0L), dew.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (w.getCount(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.f.b.toLong(dew.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.dPv.getPageActivity(), RequestResponseCode.REQUEST_SELECT_TRANSMIT_FORUM);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void diH() {
        if (ac.checkLocationForBaiduLocation(this.dPv.getPageActivity())) {
            com.baidu.adp.lib.c.a.kG().a(true, this.fwz);
        }
    }

    public void destroy() {
        if (this.mvS != null) {
            this.mvS.destroy();
        }
        if (this.mvR != null) {
            this.mvR.destroy();
        }
        if (this.mvL != null) {
            this.mvL.cancelLoadData();
        }
    }

    public void bPB() {
        this.mvS.setThreadContent(this.mvQ.due());
        this.mvS.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vR(boolean z) {
        if (this.mvQ.dug() != null && this.mvQ.due() != null) {
            int selectionEnd = this.mvQ.dug().getSelectionEnd();
            SpannableStringBuilder d = this.iyU.d(this.mvQ.dug().getText());
            if (d != null) {
                this.iyU.vF(true);
                this.mvQ.dug().setText(d);
                if (z && this.iyU.dqN() >= 0) {
                    this.mvQ.dug().requestFocus();
                    this.mvQ.dug().setSelection(this.iyU.dqN());
                } else {
                    this.mvQ.dug().setSelection(selectionEnd);
                }
                this.iyU.vE(this.iyU.dqN() >= 0);
            }
        }
    }

    public boolean dtZ() {
        if (this.iyU.dqO()) {
            this.dPv.showToast(this.iyU.dqQ());
            vR(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.iyU.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData dew;
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
                    this.dPv.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (dew = this.mvL.dew()) != null && this.mvR.drF() != null) {
                if (intent != null) {
                    dew.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                dew.setForumId("0");
                dew.setCanNoForum(true);
                dew.setRecommendExt(this.mvS.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    dua();
                } else if (ac.checkLocationForBaiduLocation(this.dPv.getPageActivity())) {
                    com.baidu.adp.lib.c.a.kG().a(true, new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
                        public void onLocationGeted(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.dua();
                        }
                    });
                }
                this.mvQ.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.dPv.showToast(postWriteCallBackData.getErrorString());
                        this.iyU.aY(postWriteCallBackData.getSensitiveWords());
                        if (!w.isEmpty(this.iyU.dqM())) {
                            vR(true);
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

    public void dua() {
        this.mvL.e("", this.mvQ.due(), this.mvR.drF().linkUrl, this.mvR.drF().linkUrlCode, this.mLat, this.mLng);
    }
}
