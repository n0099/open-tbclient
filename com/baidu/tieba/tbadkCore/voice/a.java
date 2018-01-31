package com.baidu.tieba.tbadkCore.voice;

import com.baidu.adp.lib.voice.f;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public interface a {
    void a(f fVar);

    void a(TbPageContext<?> tbPageContext);

    boolean a(f fVar, int i);

    void bR(String str);

    void release();

    void stopRecord();

    void tk();

    boolean tl();
}
