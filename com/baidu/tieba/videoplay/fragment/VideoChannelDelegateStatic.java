package com.baidu.tieba.videoplay.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import d.a.n0.e0.b;
import d.a.n0.e0.c;
import d.a.n0.e0.d;
/* loaded from: classes5.dex */
public class VideoChannelDelegateStatic extends b {

    /* loaded from: classes5.dex */
    public static class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                ((d) customResponsedMessage.getData()).a(new VideoChannelDelegateStatic());
            }
        }
    }

    static {
        a aVar = new a(2007002);
        aVar.setPriority(5);
        MessageManager.getInstance().registerListener(aVar);
    }

    @Override // d.a.n0.e0.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putString("from", VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB);
        VideoVerticalPageFragment videoVerticalPageFragment = new VideoVerticalPageFragment();
        cVar.f53115a = videoVerticalPageFragment;
        videoVerticalPageFragment.setArguments(bundle);
        cVar.f53119e = 22;
        cVar.f53116b = R.string.video_channel;
        cVar.f53123i = c.l;
        cVar.f53120f = R.raw.lottie_tab_video_channel;
        cVar.f53122h = d.a.n0.e0.e.c.d().c("channel");
        return cVar;
    }

    @Override // d.a.n0.e0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        return (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
    }

    @Override // d.a.n0.e0.b
    public boolean isAvailable() {
        return MainTabActivityConfig.VIDEO_CHANNEL_TAB_AVAILABLE;
    }

    @Override // d.a.n0.e0.b
    public void onAdd() {
        super.onAdd();
    }

    @Override // d.a.n0.e0.b
    public void onRemove() {
        super.onRemove();
        ((VideoVerticalPageFragment) getFragmentTabStructure().f53115a).onDestroy();
    }
}
