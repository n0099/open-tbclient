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
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private final TbPageContext mPageContext;
    private List<com.baidu.yuyinala.more.b.a> oMK;
    private b oML;

    /* loaded from: classes10.dex */
    public interface b {
        void a(com.baidu.yuyinala.more.b.a aVar, boolean z);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.oMK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Nd */
    public com.baidu.yuyinala.more.b.a getItem(int i) {
        return (com.baidu.yuyinala.more.b.a) ListUtils.getItem(this.oMK, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0958a c0958a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.item_audio_more_function, viewGroup, false);
            c0958a = new C0958a();
            c0958a.mRootView = view.findViewById(a.f.func_item_layout);
            c0958a.gKi = (TextView) view.findViewById(a.f.func_name_tv);
            c0958a.mIconIv = (TbImageView) view.findViewById(a.f.func_icon_iv);
            c0958a.oMP = view.findViewById(a.f.func_red_dot_iv);
            ViewGroup.LayoutParams layoutParams = c0958a.mRootView.getLayoutParams();
            layoutParams.width = (int) ((ScreenHelper.getScreenWidth(this.mPageContext.getPageActivity()) - this.mPageContext.getPageActivity().getResources().getDimension(a.d.sdk_ds48)) / 4.5d);
            c0958a.mRootView.setLayoutParams(layoutParams);
            view.setTag(c0958a);
        } else {
            c0958a = (C0958a) view.getTag();
        }
        final com.baidu.yuyinala.more.b.a aVar = (com.baidu.yuyinala.more.b.a) ListUtils.getItem(this.oMK, i);
        if (aVar != null) {
            c0958a.mRootView.setVisibility(0);
            c0958a.gKi.setText(aVar.getName());
            c0958a.mIconIv.startLoad(aVar.getIconUrl(), 10, false);
            c0958a.oMP.setVisibility(aVar.ehd() ? 0 : 8);
        } else {
            c0958a.mRootView.setVisibility(8);
        }
        c0958a.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.more.a.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        c0958a.mRootView.setAlpha(0.5f);
                        return true;
                    case 1:
                        c0958a.mRootView.setAlpha(1.0f);
                        a.this.a(aVar);
                        return true;
                    case 2:
                    default:
                        return true;
                    case 3:
                    case 4:
                        c0958a.mRootView.setAlpha(1.0f);
                        return true;
                }
            }
        });
        return view;
    }

    public void gx(List<com.baidu.yuyinala.more.b.a> list) {
        this.oMK = list;
        notifyDataSetChanged();
    }

    public void a(b bVar) {
        this.oML = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.yuyinala.more.b.a aVar) {
        if (aVar != null) {
            boolean ehd = aVar.ehd();
            aVar.Ap(false);
            notifyDataSetChanged();
            if (this.oML != null) {
                this.oML.a(aVar, ehd);
            }
        }
    }

    /* renamed from: com.baidu.yuyinala.more.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0958a {
        private TextView gKi;
        private TbImageView mIconIv;
        private View mRootView;
        private View oMP;

        private C0958a() {
        }
    }
}
