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
    private h jsb;
    private i jul;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.jsb = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cqc() {
                WriteMultiImgsActivity.this.jul.crc();
                WriteMultiImgsActivity.this.jul.rl(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cqd() {
                WriteMultiImgsActivity.this.jul.crh();
                WriteMultiImgsActivity.this.jul.rl(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean O(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.jul.Q(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cqe() {
                WriteMultiImgsActivity.this.jul.cqe();
            }
        });
        setContentView(this.jsb.eIL);
        this.jul = new i(getPageContext(), this.jsb, bundle);
        if (this.jul.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.jul.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.jul != null && this.jul.juv != null) {
            bundle.putInt("OutState_Current_Index", this.jul.juv.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.jul.crf());
            bundle.putSerializable("OutState_Write_Info_Data", this.jul.bcU());
            this.jul.juv.rg(true);
            if (this.jul.cri() != null) {
                bundle.putString("OutState_Write_Img_Info", this.jul.cri().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void crc() {
        if (this.jul != null) {
            this.jul.crc();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.jul != null) {
            if (1 == this.jul.crf()) {
                ForumWriteData bcU = this.jul.bcU();
                if (bcU != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, bcU.forumId, bcU.forumName, null, null, 0, bcU.antiData, 13003, false, false, null, false, false, null, null, bcU.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", bcU.mFrom);
                    writeActivityConfig.setCallFrom(bcU.writeCallFrom);
                    writeActivityConfig.setForumLevel(bcU.forumLevel);
                    writeActivityConfig.setForumAvatar(bcU.avatar);
                    writeActivityConfig.setPrivateThread(bcU.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            } else if (2 == this.jul.crf()) {
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
                if (!v.T(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.jsb != null) {
            this.jsb.BB(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jul != null) {
            this.jul.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.jsb != null) {
            this.jsb.onDestroy();
        }
        super.onDestroy();
    }
}
