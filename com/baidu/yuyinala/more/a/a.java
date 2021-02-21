package com.baidu.yuyinala.more.a;

import android.text.TextUtils;
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
    private List<com.baidu.yuyinala.more.b.a> oXt;
    private b oXu;

    /* loaded from: classes11.dex */
    public interface b {
        void a(com.baidu.yuyinala.more.b.a aVar, boolean z);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.oXt);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: NA */
    public com.baidu.yuyinala.more.b.a getItem(int i) {
        return (com.baidu.yuyinala.more.b.a) ListUtils.getItem(this.oXt, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0964a c0964a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.item_audio_more_function, viewGroup, false);
            c0964a = new C0964a();
            c0964a.mRootView = view.findViewById(a.f.func_item_layout);
            c0964a.gNc = (TextView) view.findViewById(a.f.func_name_tv);
            c0964a.mIconIv = (TbImageView) view.findViewById(a.f.func_icon_iv);
            c0964a.oXx = view.findViewById(a.f.func_red_dot_iv);
            c0964a.oXy = (TextView) view.findViewById(a.f.func_red_num_tv);
            ViewGroup.LayoutParams layoutParams = c0964a.mRootView.getLayoutParams();
            layoutParams.width = (int) ((ScreenHelper.getScreenWidth(this.mPageContext.getPageActivity()) - this.mPageContext.getPageActivity().getResources().getDimension(a.d.sdk_ds48)) / 4.5d);
            c0964a.mRootView.setLayoutParams(layoutParams);
            view.setTag(c0964a);
        } else {
            c0964a = (C0964a) view.getTag();
        }
        final com.baidu.yuyinala.more.b.a aVar = (com.baidu.yuyinala.more.b.a) ListUtils.getItem(this.oXt, i);
        if (aVar != null) {
            c0964a.mRootView.setVisibility(0);
            c0964a.gNc.setText(aVar.getName());
            c0964a.mIconIv.startLoad(aVar.getIconUrl(), 10, false);
            if (aVar.ejF()) {
                if (!TextUtils.isEmpty(aVar.ejD())) {
                    c0964a.oXy.setText(aVar.ejD());
                    c0964a.oXy.setVisibility(0);
                    c0964a.oXx.setVisibility(8);
                } else {
                    c0964a.oXy.setVisibility(8);
                    c0964a.oXx.setVisibility(0);
                }
            } else {
                c0964a.oXy.setVisibility(8);
                c0964a.oXx.setVisibility(8);
            }
        } else {
            c0964a.mRootView.setVisibility(8);
        }
        c0964a.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.more.a.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        c0964a.mRootView.setAlpha(0.5f);
                        return true;
                    case 1:
                        c0964a.mRootView.setAlpha(1.0f);
                        a.this.a(aVar);
                        return true;
                    case 2:
                    default:
                        return true;
                    case 3:
                    case 4:
                        c0964a.mRootView.setAlpha(1.0f);
                        return true;
                }
            }
        });
        return view;
    }

    public void gv(List<com.baidu.yuyinala.more.b.a> list) {
        this.oXt = list;
        notifyDataSetChanged();
    }

    public void a(b bVar) {
        this.oXu = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.yuyinala.more.b.a aVar) {
        if (aVar != null) {
            boolean ejF = aVar.ejF();
            aVar.AI(false);
            notifyDataSetChanged();
            if (this.oXu != null) {
                this.oXu.a(aVar, ejF);
            }
        }
    }

    /* renamed from: com.baidu.yuyinala.more.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0964a {
        private TextView gNc;
        private TbImageView mIconIv;
        private View mRootView;
        private View oXx;
        private TextView oXy;

        private C0964a() {
        }
    }
}
