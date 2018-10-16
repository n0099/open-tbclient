package com.baidu.tieba.tbadkCore.voice;

import com.baidu.adp.lib.voice.f;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public interface a {
    void a(f fVar);

    boolean a(f fVar, int i);

    void ct(String str);

    void pS();

    boolean pT();

    void release();

    void setContext(TbPageContext<?> tbPageContext);

    void stopRecord();
}
