package com.baidu.tieba.pb.pb.main.emotion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> iRv;
    private a lYk;
    private EmotionView.a lYl;

    /* loaded from: classes2.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (x.isEmpty(this.iRv)) {
            return 0;
        }
        return this.iRv.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.iRv = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0818b c0818b;
        if (view == null) {
            C0818b c0818b2 = new C0818b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0818b2.lyO = (EmotionView) view.findViewById(R.id.emotion_view);
            c0818b2.lyO.cAN();
            c0818b2.lyO.setController(this.lYl);
            c0818b2.lyO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.lYk != null && (view2 instanceof EmotionView)) {
                        b.this.lYk.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0818b2);
            c0818b = c0818b2;
        } else {
            c0818b = (C0818b) view.getTag();
        }
        if (this.iRv != null && i >= 0 && i < this.iRv.size()) {
            c0818b.lyO.a(this.iRv.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.lYk = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.lYl = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0818b {
        EmotionView lyO;

        C0818b() {
        }
    }
}
