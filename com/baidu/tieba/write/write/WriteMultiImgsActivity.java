package com.baidu.tieba.write.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes11.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private h kRi;
    private i kTr;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.kRi = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cUl() {
                WriteMultiImgsActivity.this.kTr.cVo();
                WriteMultiImgsActivity.this.kTr.tS(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cUm() {
                WriteMultiImgsActivity.this.kTr.cVt();
                WriteMultiImgsActivity.this.kTr.tS(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean N(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.kTr.P(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cUn() {
                WriteMultiImgsActivity.this.kTr.cUn();
            }
        });
        setContentView(this.kRi.fZy);
        this.kTr = new i(getPageContext(), this.kRi, bundle);
        if (this.kTr.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.kTr.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.kTr != null && this.kTr.kTB != null) {
            bundle.putInt("OutState_Current_Index", this.kTr.kTB.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.kTr.cVr());
            bundle.putSerializable("OutState_Write_Info_Data", this.kTr.bCO());
            this.kTr.kTB.tN(true);
            if (this.kTr.cVu() != null) {
                bundle.putString("OutState_Write_Img_Info", this.kTr.cVu().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cVo() {
        if (this.kTr != null) {
            this.kTr.cVo();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.kTr != null) {
            if (1 == this.kTr.cVr()) {
                ForumWriteData bCO = this.kTr.bCO();
                if (bCO != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, bCO.forumId, bCO.forumName, null, null, 0, bCO.antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, bCO.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", bCO.mFrom);
                    writeActivityConfig.setCallFrom(bCO.writeCallFrom);
                    writeActivityConfig.setForumLevel(bCO.forumLevel);
                    writeActivityConfig.setForumAvatar(bCO.avatar);
                    writeActivityConfig.setPrivateThread(bCO.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.kTr.cVr()) {
                Intent intent = new Intent(this, WriteActivity.class);
                intent.putExtra("KEY_WRITE_IMAGES_INFO_STRING", writeImagesInfo.toJsonString());
                intent.setFlags(536870912);
                intent.setFlags(67108864);
                startActivity(intent);
                finish();
                return;
            }
        }
        if (z) {
            if (writeImagesInfo != null) {
                Intent intent2 = new Intent();
                intent2.putExtra("album_result", writeImagesInfo.toJsonString());
                if (!v.isEmpty(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
                    intent2.putExtra("file_name", writeImagesInfo.getChosedFiles().get(0).extra);
                }
                setResult(-1, intent2);
            } else {
                return;
            }
        } else {
            setResult(0);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kRi != null) {
            this.kRi.Er(i);
        }
        this.kTr.kTB.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.kTr != null) {
            this.kTr.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.kRi != null) {
            this.kRi.onDestroy();
        }
        super.onDestroy();
    }
}
