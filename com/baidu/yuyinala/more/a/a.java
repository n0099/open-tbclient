package com.baidu.yuyinala.more.a;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private final TbPageContext mPageContext;
    private List<com.baidu.yuyinala.more.b.a> oun;
    private b ouo;

    /* loaded from: classes4.dex */
    public interface b {
        void a(com.baidu.yuyinala.more.b.a aVar, boolean z);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.oun);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Nu */
    public com.baidu.yuyinala.more.b.a getItem(int i) {
        return (com.baidu.yuyinala.more.b.a) ListUtils.getItem(this.oun, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final C0940a c0940a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.item_audio_more_function, viewGroup, false);
            c0940a = new C0940a();
            c0940a.mRootView = view.findViewById(a.f.func_item_layout);
            c0940a.guK = (TextView) view.findViewById(a.f.func_name_tv);
            c0940a.mIconIv = (TbImageView) view.findViewById(a.f.func_icon_iv);
            c0940a.jeO = view.findViewById(a.f.func_red_dot_iv);
            c0940a.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.more.a.a.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            c0940a.mRootView.setAlpha(0.5f);
                            return true;
                        case 1:
                            c0940a.mRootView.setAlpha(1.0f);
                            a.this.a((com.baidu.yuyinala.more.b.a) ListUtils.getItem(a.this.oun, i));
                            return true;
                        case 2:
                        default:
                            return true;
                        case 3:
                        case 4:
                            c0940a.mRootView.setAlpha(1.0f);
                            return true;
                    }
                }
            });
            ViewGroup.LayoutParams layoutParams = c0940a.mRootView.getLayoutParams();
            layoutParams.width = (int) ((ScreenHelper.getScreenWidth(this.mPageContext.getPageActivity()) - this.mPageContext.getPageActivity().getResources().getDimension(a.d.sdk_ds48)) / 4.5d);
            c0940a.mRootView.setLayoutParams(layoutParams);
            view.setTag(c0940a);
        } else {
            c0940a = (C0940a) view.getTag();
        }
        com.baidu.yuyinala.more.b.a aVar = (com.baidu.yuyinala.more.b.a) ListUtils.getItem(this.oun, i);
        if (aVar != null) {
            c0940a.mRootView.setVisibility(0);
            c0940a.guK.setText(aVar.getName());
            c0940a.mIconIv.startLoad(aVar.getIconUrl(), 10, false);
            c0940a.jeO.setVisibility(aVar.efb() ? 0 : 8);
        } else {
            c0940a.mRootView.setVisibility(8);
        }
        return view;
    }

    public void gq(List<com.baidu.yuyinala.more.b.a> list) {
        this.oun = list;
        notifyDataSetChanged();
    }

    public void a(b bVar) {
        this.ouo = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.yuyinala.more.b.a aVar) {
        if (aVar != null) {
            boolean efb = aVar.efb();
            aVar.zI(false);
            notifyDataSetChanged();
            if (this.ouo != null) {
                this.ouo.a(aVar, efb);
            }
        }
    }

    /* renamed from: com.baidu.yuyinala.more.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0940a {
        private TextView guK;
        private View jeO;
        private TbImageView mIconIv;
        private View mRootView;

        private C0940a() {
        }
    }
}
