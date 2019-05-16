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
    private h jLf;
    private i jNp;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.jLf = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cys() {
                WriteMultiImgsActivity.this.jNp.czu();
                WriteMultiImgsActivity.this.jNp.sa(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cyt() {
                WriteMultiImgsActivity.this.jNp.czz();
                WriteMultiImgsActivity.this.jNp.sa(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean P(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.jNp.R(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cyu() {
                WriteMultiImgsActivity.this.jNp.cyu();
            }
        });
        setContentView(this.jLf.eYD);
        this.jNp = new i(getPageContext(), this.jLf, bundle);
        if (this.jNp.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.jNp.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.jNp != null && this.jNp.jNz != null) {
            bundle.putInt("OutState_Current_Index", this.jNp.jNz.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.jNp.czx());
            bundle.putSerializable("OutState_Write_Info_Data", this.jNp.bkm());
            this.jNp.jNz.rV(true);
            if (this.jNp.czA() != null) {
                bundle.putString("OutState_Write_Img_Info", this.jNp.czA().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void czu() {
        if (this.jNp != null) {
            this.jNp.czu();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.jNp != null) {
            if (1 == this.jNp.czx()) {
                ForumWriteData bkm = this.jNp.bkm();
                if (bkm != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, bkm.forumId, bkm.forumName, null, null, 0, bkm.antiData, 13003, false, false, null, false, false, null, null, bkm.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", bkm.mFrom);
                    writeActivityConfig.setCallFrom(bkm.writeCallFrom);
                    writeActivityConfig.setForumLevel(bkm.forumLevel);
                    writeActivityConfig.setForumAvatar(bkm.avatar);
                    writeActivityConfig.setPrivateThread(bkm.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            } else if (2 == this.jNp.czx()) {
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
                if (!v.aa(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.jLf != null) {
            this.jLf.CH(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jNp != null) {
            this.jNp.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.jLf != null) {
            this.jLf.onDestroy();
        }
        super.onDestroy();
    }
}
