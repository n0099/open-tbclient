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
/* loaded from: classes13.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private h kTK;
    private i kVT;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.kTK = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cWb() {
                WriteMultiImgsActivity.this.kVT.cXf();
                WriteMultiImgsActivity.this.kVT.ud(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cWc() {
                WriteMultiImgsActivity.this.kVT.cXk();
                WriteMultiImgsActivity.this.kVT.ud(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean N(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.kVT.P(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cWd() {
                WriteMultiImgsActivity.this.kVT.cWd();
            }
        });
        setContentView(this.kTK.gcw);
        this.kVT = new i(getPageContext(), this.kTK, bundle);
        if (this.kVT.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.kVT.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.kVT != null && this.kVT.kWd != null) {
            bundle.putInt("OutState_Current_Index", this.kVT.kWd.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.kVT.cXi());
            bundle.putSerializable("OutState_Write_Info_Data", this.kVT.bED());
            this.kVT.kWd.tY(true);
            if (this.kVT.cXl() != null) {
                bundle.putString("OutState_Write_Img_Info", this.kVT.cXl().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cXf() {
        if (this.kVT != null) {
            this.kVT.cXf();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.kVT != null) {
            if (1 == this.kVT.cXi()) {
                ForumWriteData bED = this.kVT.bED();
                if (bED != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, bED.forumId, bED.forumName, null, null, 0, bED.antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, bED.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", bED.mFrom);
                    writeActivityConfig.setCallFrom(bED.writeCallFrom);
                    writeActivityConfig.setForumLevel(bED.forumLevel);
                    writeActivityConfig.setForumAvatar(bED.avatar);
                    writeActivityConfig.setPrivateThread(bED.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.kVT.cXi()) {
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
        if (this.kTK != null) {
            this.kTK.ED(i);
        }
        this.kVT.kWd.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.kVT != null) {
            this.kVT.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.kTK != null) {
            this.kTK.onDestroy();
        }
        super.onDestroy();
    }
}
