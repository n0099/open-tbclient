package com.baidu.tieba.videoplay.model;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.n0.z0.w;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tbclient.Feed.DataReq;
import tbclient.Feed.FeedReqIdl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/baidu/tieba/videoplay/model/VideoChannelRequestNetMessage;", "Lcom/baidu/adp/framework/message/NetMessage;", "", "isShortConnection", "", "encode", "(Z)Ljava/lang/Object;", "", "LOAD_TYPE_MORE", "I", "getLOAD_TYPE_MORE", "()I", "LOAD_TYPE_PULL", "getLOAD_TYPE_PULL", "loadType", "getLoadType", "setLoadType", "(I)V", "<init>", "()V", "VideoPlay_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes5.dex */
public final class VideoChannelRequestNetMessage extends NetMessage {
    public final int LOAD_TYPE_MORE;
    public final int LOAD_TYPE_PULL;
    public int loadType;

    public VideoChannelRequestNetMessage() {
        super(CmdConfigHttp.CMD_HTTP_VIDEO_CHANNEL_FEED, 309706);
        this.LOAD_TYPE_PULL = 1;
        this.LOAD_TYPE_MORE = 2;
        this.loadType = 1;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.scr_w = Integer.valueOf(l.k(TbadkCoreApplication.getInst()));
        builder.scr_h = Integer.valueOf(l.i(TbadkCoreApplication.getInst()));
        builder.scr_dip = Double.valueOf(l.h(TbadkCoreApplication.getInst()));
        builder.new_net_type = Integer.valueOf(j.I());
        builder.load_type = Integer.valueOf(this.loadType);
        if (z) {
            w.a(builder, true);
        }
        FeedReqIdl.Builder builder2 = new FeedReqIdl.Builder();
        builder2.data = builder.build(false);
        FeedReqIdl build = builder2.build(false);
        Intrinsics.checkExpressionValueIsNotNull(build, "idl.build(false)");
        return build;
    }

    public final int getLOAD_TYPE_MORE() {
        return this.LOAD_TYPE_MORE;
    }

    public final int getLOAD_TYPE_PULL() {
        return this.LOAD_TYPE_PULL;
    }

    public final int getLoadType() {
        return this.loadType;
    }

    public final void setLoadType(int i2) {
        this.loadType = i2;
    }
}
