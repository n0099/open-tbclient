package com.baidu.tieba.videoplay;

import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private VerticalViewPager hxN;
    private b hxO;
    public int hxP = 0;
    public int hxQ;
    private a hxR;
    private VideoPlayActivity hxS;
    private List<VideoItemData> mDatas;

    /* loaded from: classes2.dex */
    public interface a {
        void bDH();
    }

    public c(final VideoPlayActivity videoPlayActivity) {
        this.hxS = videoPlayActivity;
        this.hxN = (VerticalViewPager) videoPlayActivity.findViewById(d.g.video_play_viewpager);
        this.hxO = new b(videoPlayActivity.getSupportFragmentManager());
        this.hxN.setAdapter(this.hxO);
        this.hxN.setOffscreenPageLimit(1);
        this.hxN.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.videoplay.c.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                c.this.hxP = i;
                if (!v.E(c.this.mDatas) && c.this.mDatas.size() - 1 > 0 && c.this.mDatas.size() - i <= 2 && c.this.hxR != null) {
                    c.this.hxR.bDH();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.hxN.setOnTouchDirectionListener(new VerticalViewPager.a() { // from class: com.baidu.tieba.videoplay.c.2
            @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
            public void bDQ() {
                VideoItemData xa = c.this.hxO.xa(c.this.hxN.getCurrentItem());
                if (xa != null && xa.author_info != null) {
                    long c = com.baidu.adp.lib.g.b.c(xa.author_info.user_id, 0L);
                    long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = c == c2;
                    if (c == 0 && c2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(videoPlayActivity).createNormalConfig(c, z, false)));
                }
            }
        });
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.hxQ = i;
        this.hxO.a(this.mDatas, rect);
        this.hxO.notifyDataSetChanged();
        this.hxN.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.hxO != null) {
            this.hxO.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.hxR = aVar;
    }

    public void tU(String str) {
        if (this.hxO != null) {
            this.hxO.mFrom = str;
        }
    }

    public void onDestroy() {
        if (this.hxO != null) {
            this.hxO.bDP();
        }
    }
}
