package com.baidu.tieba.videoplay;

import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private VerticalViewPager hzi;
    private b hzj;
    public int hzk = 0;
    public int hzl;
    private a hzm;
    private VideoPlayActivity hzn;
    private List<VideoItemData> mDatas;

    /* loaded from: classes2.dex */
    public interface a {
        void bEq();
    }

    public c(final VideoPlayActivity videoPlayActivity) {
        this.hzn = videoPlayActivity;
        this.hzi = (VerticalViewPager) videoPlayActivity.findViewById(d.g.video_play_viewpager);
        this.hzj = new b(videoPlayActivity.getSupportFragmentManager());
        this.hzi.setAdapter(this.hzj);
        this.hzi.setOffscreenPageLimit(1);
        this.hzi.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.videoplay.c.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                c.this.hzk = i;
                if (!v.E(c.this.mDatas) && c.this.mDatas.size() - 1 > 0 && c.this.mDatas.size() - i <= 2 && c.this.hzm != null) {
                    c.this.hzm.bEq();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.hzi.setOnTouchDirectionListener(new VerticalViewPager.a() { // from class: com.baidu.tieba.videoplay.c.2
            @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
            public void bEz() {
                VideoItemData xa = c.this.hzj.xa(c.this.hzi.getCurrentItem());
                if (xa != null && xa.author_info != null) {
                    long c = com.baidu.adp.lib.g.b.c(xa.author_info.user_id, 0L);
                    long c2 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = c == c2;
                    if (c == 0 && c2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(videoPlayActivity).createNormalConfig(c, z, false)));
                }
            }
        });
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.hzl = i;
        this.hzj.a(this.mDatas, rect);
        this.hzj.notifyDataSetChanged();
        this.hzi.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.hzj != null) {
            this.hzj.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.hzm = aVar;
    }

    public void ug(String str) {
        if (this.hzj != null) {
            this.hzj.mFrom = str;
        }
    }

    public void onDestroy() {
        if (this.hzj != null) {
            this.hzj.bEy();
        }
    }
}
