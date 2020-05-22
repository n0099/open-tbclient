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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.aa;
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
    private static final Pattern lZK = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext dIF;
    public com.baidu.tieba.write.c ihc;
    private WriteUrlModel lZG;
    private k lZL;
    private com.baidu.tieba.write.model.a lZM;
    private com.baidu.tieba.write.transmit.model.a lZN;
    private com.baidu.tbadk.core.view.a lZO;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == R.id.icon_invoke_link) {
                    j.this.dpl();
                    TiebaStatic.log(new an("c12169"));
                }
                if (view.getId() == R.id.url_edit_back_view) {
                    j.this.dpk();
                }
            }
        }
    };
    private View.OnClickListener lZP = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == R.id.url_add) {
                TiebaStatic.log(new an("c12163"));
                String dpy = j.this.lZL.dpy();
                if (j.lZK.matcher(dpy).matches()) {
                    j.this.dpk();
                    j.this.lZM.Om(dpy);
                    j.this.lZL.a(null, true);
                    return;
                }
                TiebaStatic.log(new an("c12164"));
                j.this.lZL.dpz();
            }
        }
    };
    private TextWatcher lZQ = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.lZL.dpq();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.ihc != null) {
                if (!j.this.ihc.dmj()) {
                    j.this.vw(false);
                }
                j.this.ihc.vm(false);
            }
        }
    };
    private DialogInterface.OnCancelListener lZR = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.lZN != null) {
                j.this.lZN.bXE();
            }
        }
    };
    private a.InterfaceC0754a lQa = new a.InterfaceC0754a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0754a
        public void onError() {
            j.this.eY(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0754a
        public void g(List<SimpleForum> list, int i) {
            j.this.eY(list);
        }
    };
    private a.InterfaceC0020a flb = new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d emV = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            j.this.lZL.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.ihc.aX(null);
                j.this.ihc.vl(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (j.this.e(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.f(j.this.dIF.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    j.this.dIF.getPageActivity().setResult(-1, intent);
                    j.this.dIF.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    j.this.dIF.showToast(postWriteCallBackData.getErrorString());
                    j.this.ihc.aX(postWriteCallBackData.getSensitiveWords());
                    j.this.ihc.Of(postWriteCallBackData.getErrorString());
                    if (!v.isEmpty(j.this.ihc.dmg())) {
                        j.this.vw(true);
                    }
                } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.lZL.l(postWriteCallBackData);
                } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aYm());
                    if (!com.baidu.tbadk.s.a.yX(aaVar.aYl())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(j.this.dIF.getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(j.this.dIF.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aYl())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(j.this.dIF.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.lZO = null;
        this.dIF = tbPageContext;
        this.lZL = kVar;
        this.lZM = aVar;
        this.lZG = writeUrlModel;
        this.lZL.aj(this.mClickListener);
        this.lZL.ak(this.lZP);
        this.lZL.e(this.lZQ);
        dpl();
        this.lZO = new com.baidu.tbadk.core.view.a(this.dIF);
        this.lZO.setCancelListener(this.lZR);
        dpj();
        this.lZG.b(this.emV);
        this.ihc = new com.baidu.tieba.write.c();
        this.ihc.Ft(R.color.cp_cont_a);
        this.ihc.Fu(R.color.cp_cont_h_alpha85);
    }

    private void dpj() {
        this.lZN = new com.baidu.tieba.write.transmit.model.a(this.dIF.getUniqueId());
        this.lZN.a(this.lQa);
        if (this.lZG.cZP() != null) {
            this.lZN.setForumId(this.lZG.cZP().getForumId());
        }
    }

    protected void dpk() {
        this.lZL.dpx();
    }

    protected void dpl() {
        this.lZL.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eY(List<SimpleForum> list) {
        WriteData cZP = this.lZG.cZP();
        if (cZP != null) {
            this.lZO.setDialogVisiable(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(cZP.getForumId()) && !cZP.getForumId().equals("0") && !StringUtils.isNull(cZP.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.f.b.toLong(cZP.getForumId(), 0L), cZP.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.getCount(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.f.b.toLong(cZP.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.dIF.getPageActivity(), RequestResponseCode.REQUEST_SELECT_TRANSMIT_FORUM);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void def() {
        if (ab.checkLocationForBaiduLocation(this.dIF.getPageActivity())) {
            com.baidu.adp.lib.c.a.kq().a(true, this.flb);
        }
    }

    public void destroy() {
        if (this.lZN != null) {
            this.lZN.destroy();
        }
        if (this.lZM != null) {
            this.lZM.destroy();
        }
        if (this.lZG != null) {
            this.lZG.cancelLoadData();
        }
    }

    public void bMo() {
        this.lZN.setThreadContent(this.lZL.dpr());
        this.lZN.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vw(boolean z) {
        if (this.lZL.dpt() != null && this.lZL.dpr() != null) {
            int selectionEnd = this.lZL.dpt().getSelectionEnd();
            SpannableStringBuilder a = this.ihc.a(this.lZL.dpt().getText());
            if (a != null) {
                this.ihc.vm(true);
                this.lZL.dpt().setText(a);
                if (z && this.ihc.dmh() >= 0) {
                    this.lZL.dpt().requestFocus();
                    this.lZL.dpt().setSelection(this.ihc.dmh());
                } else {
                    this.lZL.dpt().setSelection(selectionEnd);
                }
                this.ihc.vl(this.ihc.dmh() >= 0);
            }
        }
    }

    public boolean dpm() {
        if (this.ihc.dmi()) {
            this.dIF.showToast(this.ihc.dmk());
            vw(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.ihc.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData cZP;
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
                    this.dIF.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (cZP = this.lZG.cZP()) != null && this.lZM.dmY() != null) {
                if (intent != null) {
                    cZP.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                cZP.setForumId("0");
                cZP.setCanNoForum(true);
                cZP.setRecommendExt(this.lZN.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    dpn();
                } else if (ab.checkLocationForBaiduLocation(this.dIF.getPageActivity())) {
                    com.baidu.adp.lib.c.a.kq().a(true, new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
                        public void onLocationGeted(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.dpn();
                        }
                    });
                }
                this.lZL.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.dIF.showToast(postWriteCallBackData.getErrorString());
                        this.ihc.aX(postWriteCallBackData.getSensitiveWords());
                        if (!v.isEmpty(this.ihc.dmg())) {
                            vw(true);
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

    public void dpn() {
        this.lZG.e("", this.lZL.dpr(), this.lZM.dmY().linkUrl, this.lZM.dmY().linkUrlCode, this.mLat, this.mLng);
    }
}
