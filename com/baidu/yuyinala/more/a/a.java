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
    private List<com.baidu.yuyinala.more.b.a> oKZ;
    private b oLa;

    /* loaded from: classes4.dex */
    public interface b {
        void a(com.baidu.yuyinala.more.b.a aVar, boolean z);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.oKZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: OV */
    public com.baidu.yuyinala.more.b.a getItem(int i) {
        return (com.baidu.yuyinala.more.b.a) ListUtils.getItem(this.oKZ, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final C0960a c0960a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.item_audio_more_function, viewGroup, false);
            c0960a = new C0960a();
            c0960a.mRootView = view.findViewById(a.f.func_item_layout);
            c0960a.gDc = (TextView) view.findViewById(a.f.func_name_tv);
            c0960a.mIconIv = (TbImageView) view.findViewById(a.f.func_icon_iv);
            c0960a.oLd = view.findViewById(a.f.func_red_dot_iv);
            c0960a.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.more.a.a.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            c0960a.mRootView.setAlpha(0.5f);
                            return true;
                        case 1:
                            c0960a.mRootView.setAlpha(1.0f);
                            a.this.a((com.baidu.yuyinala.more.b.a) ListUtils.getItem(a.this.oKZ, i));
                            return true;
                        case 2:
                        default:
                            return true;
                        case 3:
                        case 4:
                            c0960a.mRootView.setAlpha(1.0f);
                            return true;
                    }
                }
            });
            ViewGroup.LayoutParams layoutParams = c0960a.mRootView.getLayoutParams();
            layoutParams.width = (int) ((ScreenHelper.getScreenWidth(this.mPageContext.getPageActivity()) - this.mPageContext.getPageActivity().getResources().getDimension(a.d.sdk_ds48)) / 4.5d);
            c0960a.mRootView.setLayoutParams(layoutParams);
            view.setTag(c0960a);
        } else {
            c0960a = (C0960a) view.getTag();
        }
        com.baidu.yuyinala.more.b.a aVar = (com.baidu.yuyinala.more.b.a) ListUtils.getItem(this.oKZ, i);
        if (aVar != null) {
            c0960a.mRootView.setVisibility(0);
            c0960a.gDc.setText(aVar.getName());
            c0960a.mIconIv.startLoad(aVar.getIconUrl(), 10, false);
            c0960a.oLd.setVisibility(aVar.ekN() ? 0 : 8);
        } else {
            c0960a.mRootView.setVisibility(8);
        }
        return view;
    }

    public void gF(List<com.baidu.yuyinala.more.b.a> list) {
        this.oKZ = list;
        notifyDataSetChanged();
    }

    public void a(b bVar) {
        this.oLa = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.yuyinala.more.b.a aVar) {
        if (aVar != null) {
            boolean ekN = aVar.ekN();
            aVar.At(false);
            notifyDataSetChanged();
            if (this.oLa != null) {
                this.oLa.a(aVar, ekN);
            }
        }
    }

    /* renamed from: com.baidu.yuyinala.more.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0960a {
        private TextView gDc;
        private TbImageView mIconIv;
        private View mRootView;
        private View oLd;

        private C0960a() {
        }
    }
}
