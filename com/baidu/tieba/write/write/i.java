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
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tieba.d;
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
public class i {
    private static final Pattern hMX = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext aRI;
    public com.baidu.tieba.write.b fZO;
    private WriteUrlModel hMT;
    private j hMY;
    private com.baidu.tieba.write.model.a hMZ;
    private com.baidu.tieba.write.transmit.model.a hNa;
    private com.baidu.tbadk.core.view.b hNb;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == d.g.icon_invoke_link) {
                    i.this.bJo();
                    TiebaStatic.log(new ak("c12169"));
                }
                if (view.getId() == d.g.url_edit_back_view) {
                    i.this.bJn();
                }
            }
        }
    };
    private View.OnClickListener hNc = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == d.g.url_add) {
                TiebaStatic.log(new ak("c12163"));
                String bJB = i.this.hMY.bJB();
                if (i.hMX.matcher(bJB).matches()) {
                    i.this.bJn();
                    i.this.hMZ.uv(bJB);
                    i.this.hMY.a(null, true);
                    return;
                }
                TiebaStatic.log(new ak("c12164"));
                i.this.hMY.bJC();
            }
        }
    };
    private TextWatcher hNd = new TextWatcher() { // from class: com.baidu.tieba.write.write.i.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            i.this.hMY.bJt();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (i.this.fZO != null) {
                if (!i.this.fZO.bFJ()) {
                    i.this.nO(false);
                }
                i.this.fZO.nG(false);
            }
        }
    };
    private DialogInterface.OnCancelListener hNe = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.i.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (i.this.hNa != null) {
                i.this.hNa.awQ();
            }
        }
    };
    private a.InterfaceC0254a hDF = new a.InterfaceC0254a() { // from class: com.baidu.tieba.write.write.i.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0254a
        public void onError() {
            i.this.dZ(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0254a
        public void t(List<SimpleForum> list, int i) {
            i.this.dZ(list);
        }
    };
    private a.InterfaceC0017a cgd = new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.write.i.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                i.this.mLat = String.valueOf(address.getLatitude());
                i.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d bum = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.i.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            i.this.hMY.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                i.this.fZO.aw(null);
                i.this.fZO.nF(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (i.this.d(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.e(i.this.aRI.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    i.this.aRI.getPageActivity().setResult(-1, intent);
                    i.this.aRI.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    i.this.aRI.showToast(postWriteCallBackData.getErrorString());
                    i.this.fZO.aw(postWriteCallBackData.getSensitiveWords());
                    i.this.fZO.un(postWriteCallBackData.getErrorString());
                    if (!v.E(i.this.fZO.bFG())) {
                        i.this.nO(true);
                    }
                } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    i.this.hMY.k(postWriteCallBackData);
                } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.FY());
                    if (!com.baidu.tbadk.p.a.hx(tVar.FX())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(i.this.aRI.getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(i.this.aRI.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.FX())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(i.this.aRI.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public i(TbPageContext tbPageContext, j jVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.hNb = null;
        this.aRI = tbPageContext;
        this.hMY = jVar;
        this.hMZ = aVar;
        this.hMT = writeUrlModel;
        this.hMY.U(this.mClickListener);
        this.hMY.V(this.hNc);
        this.hMY.e(this.hNd);
        bJo();
        this.hNb = new com.baidu.tbadk.core.view.b(this.aRI);
        this.hNb.d(this.hNe);
        bJm();
        this.hMT.b(this.bum);
        this.fZO = new com.baidu.tieba.write.b();
        this.fZO.xg(d.C0141d.cp_cont_i);
        this.fZO.xh(d.C0141d.cp_cont_h_alpha85);
    }

    private void bJm() {
        this.hNa = new com.baidu.tieba.write.transmit.model.a(this.aRI.getUniqueId());
        this.hNa.a(this.hDF);
        if (this.hMT.getWriteData() != null) {
            this.hNa.setForumId(this.hMT.getWriteData().getForumId());
        }
    }

    protected void bJn() {
        this.hMY.bJA();
    }

    protected void bJo() {
        this.hMY.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZ(List<SimpleForum> list) {
        WriteData writeData = this.hMT.getWriteData();
        if (writeData != null) {
            this.hNb.bq(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(writeData.getForumId()) && !writeData.getForumId().equals("0") && !StringUtils.isNull(writeData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L), writeData.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.D(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.aRI.getPageActivity(), 25013);
            CustomMessage customMessage = new CustomMessage(2002001, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void bxG() {
        if (ab.aR(this.aRI.getPageActivity())) {
            com.baidu.adp.lib.d.a.mG().a(true, this.cgd);
        }
    }

    public void destroy() {
        if (this.hNa != null) {
            this.hNa.destroy();
        }
        if (this.hMZ != null) {
            this.hMZ.destroy();
        }
        if (this.hMT != null) {
            this.hMT.cancelLoadData();
        }
    }

    public void ane() {
        this.hNa.setThreadContent(this.hMY.bJu());
        this.hNa.Wt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nO(boolean z) {
        if (this.hMY.bJw() != null && this.hMY.bJu() != null) {
            int selectionEnd = this.hMY.bJw().getSelectionEnd();
            SpannableStringBuilder b = this.fZO.b(this.hMY.bJw().getText());
            if (b != null) {
                this.fZO.nG(true);
                this.hMY.bJw().setText(b);
                if (z && this.fZO.bFH() >= 0) {
                    this.hMY.bJw().requestFocus();
                    this.hMY.bJw().setSelection(this.fZO.bFH());
                } else {
                    this.hMY.bJw().setSelection(selectionEnd);
                }
                this.fZO.nF(this.fZO.bFH() >= 0);
            }
        }
    }

    public boolean bJp() {
        if (this.fZO.bFI()) {
            this.aRI.showToast(this.fZO.bFK());
            nO(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.fZO.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData writeData;
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
                    this.aRI.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (writeData = this.hMT.getWriteData()) != null && this.hMZ.bGW() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.hNa.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    bJq();
                } else if (ab.aR(this.aRI.getPageActivity())) {
                    com.baidu.adp.lib.d.a.mG().a(true, new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.write.i.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
                        public void b(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                i.this.mLat = String.valueOf(address.getLatitude());
                                i.this.mLng = String.valueOf(address.getLongitude());
                            }
                            i.this.bJq();
                        }
                    });
                }
                this.hMY.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.aRI.showToast(postWriteCallBackData.getErrorString());
                        this.fZO.aw(postWriteCallBackData.getSensitiveWords());
                        if (!v.E(this.fZO.bFG())) {
                            nO(true);
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

    public void bJq() {
        this.hMT.e("", this.hMY.bJu(), this.hMZ.bGW().linkUrl, this.hMZ.bGW().linkUrlCode, this.mLat, this.mLng);
    }
}
