package com.baidu.tieba.recapp.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ViewHolderStatic {
    static {
        BaseAppViewHolder.registerHolder(2, PbAppNewViewHolder.class);
        BaseAppViewHolder.registerHolder(1, PbAppViewHolder.class);
        TbadkCoreApplication.m411getInst().setRecAppExist(true);
    }
}
