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
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private final TbPageContext mPageContext;
    private List<com.baidu.yuyinala.more.b.a> okQ;
    private b okR;

    /* loaded from: classes4.dex */
    public interface b {
        void a(com.baidu.yuyinala.more.b.a aVar, boolean z);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.okQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: MZ */
    public com.baidu.yuyinala.more.b.a getItem(int i) {
        return (com.baidu.yuyinala.more.b.a) ListUtils.getItem(this.okQ, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final C0922a c0922a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.item_audio_more_function, viewGroup, false);
            c0922a = new C0922a();
            c0922a.mRootView = view.findViewById(a.g.func_item_layout);
            c0922a.goX = (TextView) view.findViewById(a.g.func_name_tv);
            c0922a.mIconIv = (TbImageView) view.findViewById(a.g.func_icon_iv);
            c0922a.iYR = view.findViewById(a.g.func_red_dot_iv);
            c0922a.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.more.a.a.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            c0922a.mRootView.setAlpha(0.5f);
                            return true;
                        case 1:
                            c0922a.mRootView.setAlpha(1.0f);
                            a.this.a((com.baidu.yuyinala.more.b.a) ListUtils.getItem(a.this.okQ, i));
                            return true;
                        case 2:
                        default:
                            return true;
                        case 3:
                        case 4:
                            c0922a.mRootView.setAlpha(1.0f);
                            return true;
                    }
                }
            });
            view.setTag(c0922a);
        } else {
            c0922a = (C0922a) view.getTag();
        }
        com.baidu.yuyinala.more.b.a aVar = (com.baidu.yuyinala.more.b.a) ListUtils.getItem(this.okQ, i);
        if (aVar != null) {
            c0922a.mRootView.setVisibility(0);
            c0922a.goX.setText(aVar.getName());
            c0922a.mIconIv.startLoad(aVar.getIconUrl(), 10, false);
            c0922a.iYR.setVisibility(aVar.ebm() ? 0 : 8);
        } else {
            c0922a.mRootView.setVisibility(8);
        }
        return view;
    }

    public void gh(List<com.baidu.yuyinala.more.b.a> list) {
        this.okQ = list;
        notifyDataSetChanged();
    }

    public void a(b bVar) {
        this.okR = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.yuyinala.more.b.a aVar) {
        if (aVar != null) {
            boolean ebm = aVar.ebm();
            aVar.zx(false);
            notifyDataSetChanged();
            if (this.okR != null) {
                this.okR.a(aVar, ebm);
            }
        }
    }

    /* renamed from: com.baidu.yuyinala.more.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0922a {
        private TextView goX;
        private View iYR;
        private TbImageView mIconIv;
        private View mRootView;

        private C0922a() {
        }
    }
}
