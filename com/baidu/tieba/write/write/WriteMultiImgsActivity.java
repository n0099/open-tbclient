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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes2.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private g hIM;
    private boolean hKN = true;
    private h hKO;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hKN = false;
        this.hIM = new g(getPageContext(), this.hKN, new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bHo() {
                WriteMultiImgsActivity.this.hKO.bIn();
                WriteMultiImgsActivity.this.hKO.nN(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bHp() {
                WriteMultiImgsActivity.this.hKO.bIo();
                WriteMultiImgsActivity.this.hKO.nN(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean A(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.hKO.C(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bHq() {
                WriteMultiImgsActivity.this.hKO.bHq();
            }
        });
        setContentView(this.hIM.dpQ);
        this.hKO = new h(getPageContext(), this.hIM, bundle);
        if (this.hKN) {
            if (this.hKO.bIt() != null) {
                i = this.hKO.bIt().size();
                i2 = this.hKO.bIt().size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.getInst().sendImagePv(i, i2, "motu_pic");
        }
        if (this.hIM != null) {
            this.hIM.xP(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.hKO != null && this.hKO.hLa != null) {
            bundle.putInt("OutState_Current_Index", this.hKO.hLa.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.hKO.bIr());
            bundle.putSerializable("OutState_Write_Info_Data", this.hKO.auz());
            this.hKO.hLa.nF(true);
            if (this.hKO.bIt() != null) {
                bundle.putString("OutState_Write_Img_Info", this.hKO.bIt().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bIn() {
        if (this.hKO != null) {
            this.hKO.bIn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bIo() {
        if (this.hKO != null) {
            this.hKO.bIo();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.hKO != null) {
            if (1 == this.hKO.bIr()) {
                ForumWriteData auz = this.hKO.auz();
                if (auz != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, auz.forumId, auz.forumName, null, null, 0, auz.antiData, 13003, false, false, null, false, false, null, null, auz.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", auz.mFrom);
                    writeActivityConfig.setCallFrom(auz.writeCallFrom);
                    writeActivityConfig.setForumLevel(auz.forumLevel);
                    writeActivityConfig.setForumAvatar(auz.avatar);
                    writeActivityConfig.setPrivateThread(auz.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.hKO.bIr()) {
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
                if (!v.E(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.hIM != null) {
            this.hIM.xP(i);
        }
    }
}
