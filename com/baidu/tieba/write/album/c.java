package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.BrowseSettingActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.write.album.AlbumActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ AlbumActivity.a fCN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AlbumActivity.a aVar) {
        this.fCN = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        albumActivity = AlbumActivity.this;
        albumActivity2 = AlbumActivity.this;
        albumActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BrowseSettingActivityConfig(albumActivity2.getPageContext().getPageActivity())));
    }
}
