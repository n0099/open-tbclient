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
    private List<com.baidu.yuyinala.more.b.a> oKX;
    private b oKY;

    /* loaded from: classes4.dex */
    public interface b {
        void a(com.baidu.yuyinala.more.b.a aVar, boolean z);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.oKX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: OV */
    public com.baidu.yuyinala.more.b.a getItem(int i) {
        return (com.baidu.yuyinala.more.b.a) ListUtils.getItem(this.oKX, i);
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
            c0960a.gDa = (TextView) view.findViewById(a.f.func_name_tv);
            c0960a.mIconIv = (TbImageView) view.findViewById(a.f.func_icon_iv);
            c0960a.oLb = view.findViewById(a.f.func_red_dot_iv);
            c0960a.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.more.a.a.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            c0960a.mRootView.setAlpha(0.5f);
                            return true;
                        case 1:
                            c0960a.mRootView.setAlpha(1.0f);
                            a.this.a((com.baidu.yuyinala.more.b.a) ListUtils.getItem(a.this.oKX, i));
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
        com.baidu.yuyinala.more.b.a aVar = (com.baidu.yuyinala.more.b.a) ListUtils.getItem(this.oKX, i);
        if (aVar != null) {
            c0960a.mRootView.setVisibility(0);
            c0960a.gDa.setText(aVar.getName());
            c0960a.mIconIv.startLoad(aVar.getIconUrl(), 10, false);
            c0960a.oLb.setVisibility(aVar.ekM() ? 0 : 8);
        } else {
            c0960a.mRootView.setVisibility(8);
        }
        return view;
    }

    public void gF(List<com.baidu.yuyinala.more.b.a> list) {
        this.oKX = list;
        notifyDataSetChanged();
    }

    public void a(b bVar) {
        this.oKY = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.yuyinala.more.b.a aVar) {
        if (aVar != null) {
            boolean ekM = aVar.ekM();
            aVar.At(false);
            notifyDataSetChanged();
            if (this.oKY != null) {
                this.oKY.a(aVar, ekM);
            }
        }
    }

    /* renamed from: com.baidu.yuyinala.more.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0960a {
        private TextView gDa;
        private TbImageView mIconIv;
        private View mRootView;
        private View oLb;

        private C0960a() {
        }
    }
}
