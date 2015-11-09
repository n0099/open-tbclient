package com.baidu.tieba.themeCenter.theme.detail;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ f diJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.diJ = fVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        c cVar;
        SkinDetailActivity skinDetailActivity;
        SkinDetailActivity skinDetailActivity2;
        c cVar2;
        TiebaStatic.log("c10277");
        cVar = this.diJ.diH;
        cVar.getItem(i);
        skinDetailActivity = this.diJ.diE;
        skinDetailActivity2 = this.diJ.diE;
        ImageViewerConfig imageViewerConfig = new ImageViewerConfig(skinDetailActivity2.getPageContext().getPageActivity());
        cVar2 = this.diJ.diH;
        skinDetailActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, imageViewerConfig.createConfig(cVar2.aAp(), i, null, "", "", true, "", true)));
    }
}
