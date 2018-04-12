package com.baidu.tieba.write.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes3.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private h hge;
    private i hin;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hge = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bCS() {
                WriteMultiImgsActivity.this.hin.bDT();
                WriteMultiImgsActivity.this.hin.nA(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bCT() {
                WriteMultiImgsActivity.this.hin.bDY();
                WriteMultiImgsActivity.this.hin.nA(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean H(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.hin.J(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bCU() {
                WriteMultiImgsActivity.this.hin.bCU();
            }
        });
        setContentView(this.hge.cLr);
        this.hin = new i(getPageContext(), this.hge, bundle);
        if (this.hin.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.hin.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.hin != null && this.hin.hix != null) {
            bundle.putInt("OutState_Current_Index", this.hin.hix.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.hin.bDW());
            bundle.putSerializable("OutState_Write_Info_Data", this.hin.apH());
            this.hin.hix.nu(true);
            if (this.hin.bDZ() != null) {
                bundle.putString("OutState_Write_Img_Info", this.hin.bDZ().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bDT() {
        if (this.hin != null) {
            this.hin.bDT();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.hin != null) {
            if (1 == this.hin.bDW()) {
                ForumWriteData apH = this.hin.apH();
                if (apH != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, apH.forumId, apH.forumName, null, null, 0, apH.antiData, 13003, false, false, null, false, false, null, null, apH.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", apH.mFrom);
                    writeActivityConfig.setCallFrom(apH.writeCallFrom);
                    writeActivityConfig.setForumLevel(apH.forumLevel);
                    writeActivityConfig.setForumAvatar(apH.avatar);
                    writeActivityConfig.setPrivateThread(apH.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            } else if (2 == this.hin.bDW()) {
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
                intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, writeImagesInfo.toJsonString());
                if (!v.w(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.hge != null) {
            this.hge.vm(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hin != null) {
            this.hin.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.hge != null) {
            this.hge.onDestroy();
        }
        super.onDestroy();
    }
}
