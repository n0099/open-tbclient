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
    private h jLg;
    private i jNq;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.jLg = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cyu() {
                WriteMultiImgsActivity.this.jNq.czw();
                WriteMultiImgsActivity.this.jNq.sa(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cyv() {
                WriteMultiImgsActivity.this.jNq.czB();
                WriteMultiImgsActivity.this.jNq.sa(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean P(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.jNq.R(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cyw() {
                WriteMultiImgsActivity.this.jNq.cyw();
            }
        });
        setContentView(this.jLg.eYE);
        this.jNq = new i(getPageContext(), this.jLg, bundle);
        if (this.jNq.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.jNq.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.jNq != null && this.jNq.jNA != null) {
            bundle.putInt("OutState_Current_Index", this.jNq.jNA.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.jNq.czz());
            bundle.putSerializable("OutState_Write_Info_Data", this.jNq.bkp());
            this.jNq.jNA.rV(true);
            if (this.jNq.czC() != null) {
                bundle.putString("OutState_Write_Img_Info", this.jNq.czC().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void czw() {
        if (this.jNq != null) {
            this.jNq.czw();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.jNq != null) {
            if (1 == this.jNq.czz()) {
                ForumWriteData bkp = this.jNq.bkp();
                if (bkp != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, bkp.forumId, bkp.forumName, null, null, 0, bkp.antiData, 13003, false, false, null, false, false, null, null, bkp.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", bkp.mFrom);
                    writeActivityConfig.setCallFrom(bkp.writeCallFrom);
                    writeActivityConfig.setForumLevel(bkp.forumLevel);
                    writeActivityConfig.setForumAvatar(bkp.avatar);
                    writeActivityConfig.setPrivateThread(bkp.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            } else if (2 == this.jNq.czz()) {
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
        if (this.jLg != null) {
            this.jLg.CH(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jNq != null) {
            this.jNq.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.jLg != null) {
            this.jLg.onDestroy();
        }
        super.onDestroy();
    }
}
