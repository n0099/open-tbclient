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
    private VerticalViewPager hIg;
    private b hIh;
    public int hIi = 0;
    public int hIj;
    private a hIk;
    private VideoPlayActivity hIl;
    private List<VideoItemData> mDatas;

    /* loaded from: classes2.dex */
    public interface a {
        void blk();
    }

    public c(final VideoPlayActivity videoPlayActivity) {
        this.hIl = videoPlayActivity;
        this.hIg = (VerticalViewPager) videoPlayActivity.findViewById(d.g.video_play_viewpager);
        this.hIh = new b(videoPlayActivity.getSupportFragmentManager());
        this.hIg.setAdapter(this.hIh);
        this.hIg.setOffscreenPageLimit(1);
        this.hIg.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.videoplay.c.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                c.this.hIi = i;
                if (!v.G(c.this.mDatas) && c.this.mDatas.size() - 1 > 0 && c.this.mDatas.size() - i <= 2 && c.this.hIk != null) {
                    c.this.hIk.blk();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.hIg.setOnTouchDirectionListener(new VerticalViewPager.a() { // from class: com.baidu.tieba.videoplay.c.2
            @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
            public void bKq() {
                VideoItemData yy = c.this.hIh.yy(c.this.hIg.getCurrentItem());
                if (yy != null && yy.author_info != null) {
                    long c = com.baidu.adp.lib.g.b.c(yy.author_info.user_id, 0L);
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
        this.hIj = i;
        this.hIh.a(this.mDatas, rect);
        this.hIh.notifyDataSetChanged();
        this.hIg.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.hIh != null) {
            this.hIh.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.hIk = aVar;
    }

    public void uz(String str) {
        if (this.hIh != null) {
            this.hIh.mFrom = str;
        }
    }
}
