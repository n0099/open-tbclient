package com.baidu.tieba.themeCenter.theme.detail;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ g dGU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.dGU = gVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        SkinDetailActivity skinDetailActivity;
        SkinDetailActivity skinDetailActivity2;
        d dVar2;
        TiebaStatic.log("c10277");
        dVar = this.dGU.dGS;
        dVar.getItem(i);
        skinDetailActivity = this.dGU.dGP;
        skinDetailActivity2 = this.dGU.dGP;
        ImageViewerConfig imageViewerConfig = new ImageViewerConfig(skinDetailActivity2.getPageContext().getPageActivity());
        dVar2 = this.dGU.dGS;
        skinDetailActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, imageViewerConfig.createConfig(dVar2.aFA(), i, null, "", "", true, "", true)));
    }
}
