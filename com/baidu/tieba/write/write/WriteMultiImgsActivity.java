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
    private h hPN;
    private i hRW;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hPN = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bMO() {
                WriteMultiImgsActivity.this.hRW.bNP();
                WriteMultiImgsActivity.this.hRW.oF(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bMP() {
                WriteMultiImgsActivity.this.hRW.bNU();
                WriteMultiImgsActivity.this.hRW.oF(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean G(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.hRW.I(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bMQ() {
                WriteMultiImgsActivity.this.hRW.bMQ();
            }
        });
        setContentView(this.hPN.dlu);
        this.hRW = new i(getPageContext(), this.hPN, bundle);
        if (this.hRW.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.hRW.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.hRW != null && this.hRW.hSg != null) {
            bundle.putInt("OutState_Current_Index", this.hRW.hSg.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.hRW.bNS());
            bundle.putSerializable("OutState_Write_Info_Data", this.hRW.azs());
            this.hRW.hSg.oA(true);
            if (this.hRW.bNV() != null) {
                bundle.putString("OutState_Write_Img_Info", this.hRW.bNV().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bNP() {
        if (this.hRW != null) {
            this.hRW.bNP();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.hRW != null) {
            if (1 == this.hRW.bNS()) {
                ForumWriteData azs = this.hRW.azs();
                if (azs != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, azs.forumId, azs.forumName, null, null, 0, azs.antiData, 13003, false, false, null, false, false, null, null, azs.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", azs.mFrom);
                    writeActivityConfig.setCallFrom(azs.writeCallFrom);
                    writeActivityConfig.setForumLevel(azs.forumLevel);
                    writeActivityConfig.setForumAvatar(azs.avatar);
                    writeActivityConfig.setPrivateThread(azs.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            } else if (2 == this.hRW.bNS()) {
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
                if (!v.I(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.hPN != null) {
            this.hPN.xa(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hRW != null) {
            this.hRW.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.hPN != null) {
            this.hPN.onDestroy();
        }
        super.onDestroy();
    }
}
