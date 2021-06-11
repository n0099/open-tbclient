package com.baidu.tieba.videoplay.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class VideoChannelModel extends BdBaseModel {
    public static final String TYPE_CALL_FROM_FRS = "client_frs";
    public static final String TYPE_CALL_FROM_INDEX = "client_index";
    public static final String TYPE_CALL_FROM_OTHER = "client_other";

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f21619e;

    /* renamed from: f  reason: collision with root package name */
    public c f21620f;

    /* renamed from: g  reason: collision with root package name */
    public int f21621g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21622h;

    /* renamed from: i  reason: collision with root package name */
    public HttpMessageListener f21623i;
    public CustomMessageListener j;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public a(int i2, boolean z) {
            super(i2, z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                return;
            }
            List<VideoItemData> arrayList = new ArrayList<>();
            if (httpResponsedMessage instanceof VideoChannelHttpResponseMessage) {
                arrayList = ((VideoChannelHttpResponseMessage) httpResponsedMessage).getVideoItemDatas();
            }
            TbSingleton.getInstance().clearVideoRecord();
            if (VideoChannelModel.this.f21620f != null) {
                if (VideoChannelModel.this.f21621g == 1) {
                    VideoChannelModel.this.f21620f.a(arrayList, VideoChannelModel.this.f21622h);
                    VideoChannelModel.this.f21622h = false;
                } else {
                    VideoChannelModel.this.f21620f.b(arrayList);
                }
            }
            VideoChannelModel.y(VideoChannelModel.this);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            if (j.z()) {
                VideoChannelModel.this.f21622h = true;
                VideoChannelModel.this.D();
                return;
            }
            l.J(VideoChannelModel.this.f21619e.getPageActivity(), VideoChannelModel.this.f21619e.getResources().getString(R.string.neterror));
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(List<VideoItemData> list, boolean z);

        void b(List<VideoItemData> list);
    }

    public VideoChannelModel(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.f21622h = false;
        this.f21623i = new a(CmdConfigHttp.CMD_HTTP_VIDEO_CHANNEL_FEED, true);
        this.j = new b(2921567);
        this.f21619e = tbPageContext;
        setUniqueId(bdUniqueId);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_VIDEO_CHANNEL_FEED, TbConfig.SERVER_ADDRESS + "c/f/video/feed");
        tbHttpMessageTask.setResponsedClass(VideoChannelHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.f21623i);
        registerListener(this.j);
    }

    public static /* synthetic */ int y(VideoChannelModel videoChannelModel) {
        int i2 = videoChannelModel.f21621g;
        videoChannelModel.f21621g = i2 + 1;
        return i2;
    }

    public final NetMessage C(int i2) {
        VideoChannelRequestNetMessage videoChannelRequestNetMessage = new VideoChannelRequestNetMessage();
        videoChannelRequestNetMessage.setLoadType(i2);
        return videoChannelRequestNetMessage;
    }

    public void D() {
        this.f21621g = 1;
        sendMessage(C(1));
    }

    public void E(c cVar) {
        this.f21620f = cVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void loadMore() {
        sendMessage(C(2));
    }

    public void setFrom(String str) {
    }
}
