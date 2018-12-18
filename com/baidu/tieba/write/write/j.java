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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tieba.e;
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
    private static final Pattern hZE = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    public com.baidu.tieba.write.b ghU;
    private WriteUrlModel hZA;
    private k hZF;
    private com.baidu.tieba.write.model.a hZG;
    private com.baidu.tieba.write.transmit.model.a hZH;
    private com.baidu.tbadk.core.view.d hZI;
    private TbPageContext mContext;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == e.g.icon_invoke_link) {
                    j.this.bQd();
                    TiebaStatic.log(new am("c12169"));
                }
                if (view.getId() == e.g.url_edit_back_view) {
                    j.this.bQc();
                }
            }
        }
    };
    private View.OnClickListener hZJ = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == e.g.url_add) {
                TiebaStatic.log(new am("c12163"));
                String bQq = j.this.hZF.bQq();
                if (j.hZE.matcher(bQq).matches()) {
                    j.this.bQc();
                    j.this.hZG.xB(bQq);
                    j.this.hZF.a(null, true);
                    return;
                }
                TiebaStatic.log(new am("c12164"));
                j.this.hZF.bQr();
            }
        }
    };
    private TextWatcher hZK = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.hZF.bQi();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.ghU != null) {
                if (!j.this.ghU.bMX()) {
                    j.this.oA(false);
                }
                j.this.ghU.or(false);
            }
        }
    };
    private DialogInterface.OnCancelListener hZL = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.hZH != null) {
                j.this.hZH.aDd();
            }
        }
    };
    private a.InterfaceC0338a hQv = new a.InterfaceC0338a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0338a
        public void onError() {
            j.this.em(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0338a
        public void h(List<SimpleForum> list, int i) {
            j.this.em(list);
        }
    };
    private a.InterfaceC0017a bTD = new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d baf = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
            j.this.hZF.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.ghU.az(null);
                j.this.ghU.oq(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (j.this.d(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.e(j.this.mContext.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    j.this.mContext.getPageActivity().setResult(-1, intent);
                    j.this.mContext.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    j.this.mContext.showToast(postWriteCallBackData.getErrorString());
                    j.this.ghU.az(postWriteCallBackData.getSensitiveWords());
                    j.this.ghU.xr(postWriteCallBackData.getErrorString());
                    if (!v.I(j.this.ghU.bMU())) {
                        j.this.oA(true);
                    }
                } else if ((wVar == null || writeData == null || wVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.hZF.l(postWriteCallBackData);
                } else if (wVar != null && writeData != null && wVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(wVar.getVcode_md5());
                    writeData.setVcodeUrl(wVar.getVcode_pic_url());
                    writeData.setVcodeExtra(wVar.GW());
                    if (!com.baidu.tbadk.r.a.iS(wVar.GV())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(j.this.mContext.getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, wVar.GV())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.hZI = null;
        this.mContext = tbPageContext;
        this.hZF = kVar;
        this.hZG = aVar;
        this.hZA = writeUrlModel;
        this.hZF.Z(this.mClickListener);
        this.hZF.aa(this.hZJ);
        this.hZF.e(this.hZK);
        bQd();
        this.hZI = new com.baidu.tbadk.core.view.d(this.mContext);
        this.hZI.d(this.hZL);
        bQb();
        this.hZA.b(this.baf);
        this.ghU = new com.baidu.tieba.write.b();
        this.ghU.wV(e.d.cp_cont_i);
        this.ghU.wW(e.d.cp_cont_h_alpha85);
    }

    private void bQb() {
        this.hZH = new com.baidu.tieba.write.transmit.model.a(this.mContext.getUniqueId());
        this.hZH.a(this.hQv);
        if (this.hZA.getWriteData() != null) {
            this.hZH.setForumId(this.hZA.getWriteData().getForumId());
        }
    }

    protected void bQc() {
        this.hZF.bQp();
    }

    protected void bQd() {
        this.hZF.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void em(List<SimpleForum> list) {
        WriteData writeData = this.hZA.getWriteData();
        if (writeData != null) {
            this.hZI.bA(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(writeData.getForumId()) && !writeData.getForumId().equals("0") && !StringUtils.isNull(writeData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.d(writeData.getForumId(), 0L), writeData.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.H(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.d(writeData.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.mContext.getPageActivity(), 25013);
            CustomMessage customMessage = new CustomMessage(2002001, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void bDY() {
        if (ab.bB(this.mContext.getPageActivity())) {
            com.baidu.adp.lib.d.a.iW().a(true, this.bTD);
        }
    }

    public void destroy() {
        if (this.hZH != null) {
            this.hZH.destroy();
        }
        if (this.hZG != null) {
            this.hZG.destroy();
        }
        if (this.hZA != null) {
            this.hZA.cancelLoadData();
        }
    }

    public void ard() {
        this.hZH.setThreadContent(this.hZF.bQj());
        this.hZH.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oA(boolean z) {
        if (this.hZF.bQl() != null && this.hZF.bQj() != null) {
            int selectionEnd = this.hZF.bQl().getSelectionEnd();
            SpannableStringBuilder b = this.ghU.b(this.hZF.bQl().getText());
            if (b != null) {
                this.ghU.or(true);
                this.hZF.bQl().setText(b);
                if (z && this.ghU.bMV() >= 0) {
                    this.hZF.bQl().requestFocus();
                    this.hZF.bQl().setSelection(this.ghU.bMV());
                } else {
                    this.hZF.bQl().setSelection(selectionEnd);
                }
                this.ghU.oq(this.ghU.bMV() >= 0);
            }
        }
    }

    public boolean bQe() {
        if (this.ghU.bMW()) {
            this.mContext.showToast(this.ghU.bMY());
            oA(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.ghU.onChangeSkinType();
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
                    this.mContext.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (writeData = this.hZA.getWriteData()) != null && this.hZG.bOh() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.hZH.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    bQf();
                } else if (ab.bB(this.mContext.getPageActivity())) {
                    com.baidu.adp.lib.d.a.iW().a(true, new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
                        public void b(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.bQf();
                        }
                    });
                }
                this.hZF.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.mContext.showToast(postWriteCallBackData.getErrorString());
                        this.ghU.az(postWriteCallBackData.getSensitiveWords());
                        if (!v.I(this.ghU.bMU())) {
                            oA(true);
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

    public void bQf() {
        this.hZA.g("", this.hZF.bQj(), this.hZG.bOh().linkUrl, this.hZG.bOh().linkUrlCode, this.mLat, this.mLng);
    }
}
