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
    private h jsd;
    private i jun;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.jsd = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cqn() {
                WriteMultiImgsActivity.this.jun.crn();
                WriteMultiImgsActivity.this.jun.rl(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cqo() {
                WriteMultiImgsActivity.this.jun.crs();
                WriteMultiImgsActivity.this.jun.rl(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean O(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.jun.Q(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cqp() {
                WriteMultiImgsActivity.this.jun.cqp();
            }
        });
        setContentView(this.jsd.eIu);
        this.jun = new i(getPageContext(), this.jsd, bundle);
        if (this.jun.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.jun.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.jun != null && this.jun.jux != null) {
            bundle.putInt("OutState_Current_Index", this.jun.jux.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.jun.crq());
            bundle.putSerializable("OutState_Write_Info_Data", this.jun.bcS());
            this.jun.jux.rg(true);
            if (this.jun.crt() != null) {
                bundle.putString("OutState_Write_Img_Info", this.jun.crt().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void crn() {
        if (this.jun != null) {
            this.jun.crn();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.jun != null) {
            if (1 == this.jun.crq()) {
                ForumWriteData bcS = this.jun.bcS();
                if (bcS != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, bcS.forumId, bcS.forumName, null, null, 0, bcS.antiData, 13003, false, false, null, false, false, null, null, bcS.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", bcS.mFrom);
                    writeActivityConfig.setCallFrom(bcS.writeCallFrom);
                    writeActivityConfig.setForumLevel(bcS.forumLevel);
                    writeActivityConfig.setForumAvatar(bcS.avatar);
                    writeActivityConfig.setPrivateThread(bcS.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            } else if (2 == this.jun.crq()) {
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
        if (this.jsd != null) {
            this.jsd.By(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jun != null) {
            this.jun.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.jsd != null) {
            this.jsd.onDestroy();
        }
        super.onDestroy();
    }
}
