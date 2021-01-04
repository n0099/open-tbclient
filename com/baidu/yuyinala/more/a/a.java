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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private final TbPageContext mPageContext;
    private List<com.baidu.yuyinala.more.b.a> oRl;
    private b oRm;

    /* loaded from: classes11.dex */
    public interface b {
        void a(com.baidu.yuyinala.more.b.a aVar, boolean z);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.oRl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: OK */
    public com.baidu.yuyinala.more.b.a getItem(int i) {
        return (com.baidu.yuyinala.more.b.a) ListUtils.getItem(this.oRl, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0937a c0937a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.item_audio_more_function, viewGroup, false);
            c0937a = new C0937a();
            c0937a.mRootView = view.findViewById(a.f.func_item_layout);
            c0937a.gOO = (TextView) view.findViewById(a.f.func_name_tv);
            c0937a.mIconIv = (TbImageView) view.findViewById(a.f.func_icon_iv);
            c0937a.oRq = view.findViewById(a.f.func_red_dot_iv);
            ViewGroup.LayoutParams layoutParams = c0937a.mRootView.getLayoutParams();
            layoutParams.width = (int) ((ScreenHelper.getScreenWidth(this.mPageContext.getPageActivity()) - this.mPageContext.getPageActivity().getResources().getDimension(a.d.sdk_ds48)) / 4.5d);
            c0937a.mRootView.setLayoutParams(layoutParams);
            view.setTag(c0937a);
        } else {
            c0937a = (C0937a) view.getTag();
        }
        final com.baidu.yuyinala.more.b.a aVar = (com.baidu.yuyinala.more.b.a) ListUtils.getItem(this.oRl, i);
        if (aVar != null) {
            c0937a.mRootView.setVisibility(0);
            c0937a.gOO.setText(aVar.getName());
            c0937a.mIconIv.startLoad(aVar.getIconUrl(), 10, false);
            c0937a.oRq.setVisibility(aVar.ekW() ? 0 : 8);
        } else {
            c0937a.mRootView.setVisibility(8);
        }
        c0937a.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.more.a.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        c0937a.mRootView.setAlpha(0.5f);
                        return true;
                    case 1:
                        c0937a.mRootView.setAlpha(1.0f);
                        a.this.a(aVar);
                        return true;
                    case 2:
                    default:
                        return true;
                    case 3:
                    case 4:
                        c0937a.mRootView.setAlpha(1.0f);
                        return true;
                }
            }
        });
        return view;
    }

    public void gx(List<com.baidu.yuyinala.more.b.a> list) {
        this.oRl = list;
        notifyDataSetChanged();
    }

    public void a(b bVar) {
        this.oRm = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.yuyinala.more.b.a aVar) {
        if (aVar != null) {
            boolean ekW = aVar.ekW();
            aVar.At(false);
            notifyDataSetChanged();
            if (this.oRm != null) {
                this.oRm.a(aVar, ekW);
            }
        }
    }

    /* renamed from: com.baidu.yuyinala.more.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0937a {
        private TextView gOO;
        private TbImageView mIconIv;
        private View mRootView;
        private View oRq;

        private C0937a() {
        }
    }
}
