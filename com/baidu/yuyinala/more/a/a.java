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
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private final TbPageContext mPageContext;
    private List<com.baidu.yuyinala.more.b.a> oZy;
    private b oZz;

    /* loaded from: classes10.dex */
    public interface b {
        void a(com.baidu.yuyinala.more.b.a aVar, boolean z);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.oZy);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: NE */
    public com.baidu.yuyinala.more.b.a getItem(int i) {
        return (com.baidu.yuyinala.more.b.a) ListUtils.getItem(this.oZy, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0970a c0970a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.item_audio_more_function, viewGroup, false);
            c0970a = new C0970a();
            c0970a.mRootView = view.findViewById(a.f.func_item_layout);
            c0970a.gOL = (TextView) view.findViewById(a.f.func_name_tv);
            c0970a.mIconIv = (TbImageView) view.findViewById(a.f.func_icon_iv);
            c0970a.oZC = view.findViewById(a.f.func_red_dot_iv);
            c0970a.oZD = (TextView) view.findViewById(a.f.func_red_num_tv);
            ViewGroup.LayoutParams layoutParams = c0970a.mRootView.getLayoutParams();
            layoutParams.width = (int) ((ScreenHelper.getScreenWidth(this.mPageContext.getPageActivity()) - this.mPageContext.getPageActivity().getResources().getDimension(a.d.sdk_ds48)) / 4.5d);
            c0970a.mRootView.setLayoutParams(layoutParams);
            view.setTag(c0970a);
        } else {
            c0970a = (C0970a) view.getTag();
        }
        final com.baidu.yuyinala.more.b.a aVar = (com.baidu.yuyinala.more.b.a) ListUtils.getItem(this.oZy, i);
        if (aVar != null) {
            c0970a.mRootView.setVisibility(0);
            c0970a.gOL.setText(aVar.getName());
            c0970a.mIconIv.startLoad(aVar.getIconUrl(), 10, false);
            if (aVar.ejP()) {
                if (!TextUtils.isEmpty(aVar.ejN())) {
                    c0970a.oZD.setText(aVar.ejN());
                    c0970a.oZD.setVisibility(0);
                    c0970a.oZC.setVisibility(8);
                } else {
                    c0970a.oZD.setVisibility(8);
                    c0970a.oZC.setVisibility(0);
                }
            } else {
                c0970a.oZD.setVisibility(8);
                c0970a.oZC.setVisibility(8);
            }
        } else {
            c0970a.mRootView.setVisibility(8);
        }
        c0970a.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.more.a.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        c0970a.mRootView.setAlpha(0.5f);
                        return true;
                    case 1:
                        c0970a.mRootView.setAlpha(1.0f);
                        a.this.a(aVar);
                        return true;
                    case 2:
                    default:
                        return true;
                    case 3:
                    case 4:
                        c0970a.mRootView.setAlpha(1.0f);
                        return true;
                }
            }
        });
        return view;
    }

    public void gv(List<com.baidu.yuyinala.more.b.a> list) {
        this.oZy = list;
        notifyDataSetChanged();
    }

    public void a(b bVar) {
        this.oZz = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.yuyinala.more.b.a aVar) {
        if (aVar != null) {
            boolean ejP = aVar.ejP();
            aVar.AH(false);
            notifyDataSetChanged();
            if (this.oZz != null) {
                this.oZz.a(aVar, ejP);
            }
        }
    }

    /* renamed from: com.baidu.yuyinala.more.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0970a {
        private TextView gOL;
        private TbImageView mIconIv;
        private View mRootView;
        private View oZC;
        private TextView oZD;

        private C0970a() {
        }
    }
}
