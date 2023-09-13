package com.baidu.tieba;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
/* loaded from: classes7.dex */
public interface rr9 {
    PbFragment O1();

    AbsVideoPbFragment S();

    PbModel.h W0();

    PbModel X();

    AbsPbActivity e0();

    void finish();

    TbPageContext getPageContext();

    void registerListener(MessageListener<?> messageListener);
}
