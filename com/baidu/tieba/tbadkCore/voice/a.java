package com.baidu.tieba.tbadkCore.voice;

import com.baidu.adp.lib.voice.f;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public interface a {
    void a(f fVar);

    boolean a(f fVar, int i);

    void cu(String str);

    void pK();

    boolean pL();

    void release();

    void setContext(TbPageContext<?> tbPageContext);

    void stopRecord();
}
