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
    private VideoPlayActivity hzA;
    private VerticalViewPager hzv;
    private b hzw;
    public int hzx = 0;
    public int hzy;
    private a hzz;
    private List<VideoItemData> mDatas;

    /* loaded from: classes2.dex */
    public interface a {
        void bEr();
    }

    public c(final VideoPlayActivity videoPlayActivity) {
        this.hzA = videoPlayActivity;
        this.hzv = (VerticalViewPager) videoPlayActivity.findViewById(d.g.video_play_viewpager);
        this.hzw = new b(videoPlayActivity.getSupportFragmentManager());
        this.hzv.setAdapter(this.hzw);
        this.hzv.setOffscreenPageLimit(1);
        this.hzv.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.videoplay.c.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                c.this.hzx = i;
                if (!v.E(c.this.mDatas) && c.this.mDatas.size() - 1 > 0 && c.this.mDatas.size() - i <= 2 && c.this.hzz != null) {
                    c.this.hzz.bEr();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.hzv.setOnTouchDirectionListener(new VerticalViewPager.a() { // from class: com.baidu.tieba.videoplay.c.2
            @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
            public void bEA() {
                VideoItemData wZ = c.this.hzw.wZ(c.this.hzv.getCurrentItem());
                if (wZ != null && wZ.author_info != null) {
                    long c = com.baidu.adp.lib.g.b.c(wZ.author_info.user_id, 0L);
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
        this.hzy = i;
        this.hzw.a(this.mDatas, rect);
        this.hzw.notifyDataSetChanged();
        this.hzv.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.hzw != null) {
            this.hzw.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.hzz = aVar;
    }

    public void ug(String str) {
        if (this.hzw != null) {
            this.hzw.mFrom = str;
        }
    }

    public void onDestroy() {
        if (this.hzw != null) {
            this.hzw.bEz();
        }
    }
}
