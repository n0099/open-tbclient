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
    private VerticalViewPager hyh;
    private b hyi;
    public int hyj = 0;
    public int hyk;
    private a hyl;
    private VideoPlayActivity hym;
    private List<VideoItemData> mDatas;

    /* loaded from: classes2.dex */
    public interface a {
        void bDJ();
    }

    public c(final VideoPlayActivity videoPlayActivity) {
        this.hym = videoPlayActivity;
        this.hyh = (VerticalViewPager) videoPlayActivity.findViewById(d.g.video_play_viewpager);
        this.hyi = new b(videoPlayActivity.getSupportFragmentManager());
        this.hyh.setAdapter(this.hyi);
        this.hyh.setOffscreenPageLimit(1);
        this.hyh.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.videoplay.c.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                c.this.hyj = i;
                if (!v.E(c.this.mDatas) && c.this.mDatas.size() - 1 > 0 && c.this.mDatas.size() - i <= 2 && c.this.hyl != null) {
                    c.this.hyl.bDJ();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.hyh.setOnTouchDirectionListener(new VerticalViewPager.a() { // from class: com.baidu.tieba.videoplay.c.2
            @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
            public void bDS() {
                VideoItemData xa = c.this.hyi.xa(c.this.hyh.getCurrentItem());
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
        this.hyk = i;
        this.hyi.a(this.mDatas, rect);
        this.hyi.notifyDataSetChanged();
        this.hyh.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.hyi != null) {
            this.hyi.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.hyl = aVar;
    }

    public void uc(String str) {
        if (this.hyi != null) {
            this.hyi.mFrom = str;
        }
    }

    public void onDestroy() {
        if (this.hyi != null) {
            this.hyi.bDR();
        }
    }
}
