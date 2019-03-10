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
    private h jsu;
    private i juE;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.jsu = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cqm() {
                WriteMultiImgsActivity.this.juE.crm();
                WriteMultiImgsActivity.this.juE.rl(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cqn() {
                WriteMultiImgsActivity.this.juE.crr();
                WriteMultiImgsActivity.this.juE.rl(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean O(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.juE.Q(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cqo() {
                WriteMultiImgsActivity.this.juE.cqo();
            }
        });
        setContentView(this.jsu.eIL);
        this.juE = new i(getPageContext(), this.jsu, bundle);
        if (this.juE.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.juE.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.juE != null && this.juE.juO != null) {
            bundle.putInt("OutState_Current_Index", this.juE.juO.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.juE.crp());
            bundle.putSerializable("OutState_Write_Info_Data", this.juE.bcV());
            this.juE.juO.rg(true);
            if (this.juE.crs() != null) {
                bundle.putString("OutState_Write_Img_Info", this.juE.crs().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void crm() {
        if (this.juE != null) {
            this.juE.crm();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.juE != null) {
            if (1 == this.juE.crp()) {
                ForumWriteData bcV = this.juE.bcV();
                if (bcV != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, bcV.forumId, bcV.forumName, null, null, 0, bcV.antiData, 13003, false, false, null, false, false, null, null, bcV.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", bcV.mFrom);
                    writeActivityConfig.setCallFrom(bcV.writeCallFrom);
                    writeActivityConfig.setForumLevel(bcV.forumLevel);
                    writeActivityConfig.setForumAvatar(bcV.avatar);
                    writeActivityConfig.setPrivateThread(bcV.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            } else if (2 == this.juE.crp()) {
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
        if (this.jsu != null) {
            this.jsu.BC(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.juE != null) {
            this.juE.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.jsu != null) {
            this.jsu.onDestroy();
        }
        super.onDestroy();
    }
}
