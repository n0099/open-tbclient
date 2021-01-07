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
    private a lYj;
    private EmotionView.a lYk;

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
        C0851b c0851b;
        if (view == null) {
            C0851b c0851b2 = new C0851b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0851b2.lyO = (EmotionView) view.findViewById(R.id.emotion_view);
            c0851b2.lyO.cAO();
            c0851b2.lyO.setController(this.lYk);
            c0851b2.lyO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.lYj != null && (view2 instanceof EmotionView)) {
                        b.this.lYj.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0851b2);
            c0851b = c0851b2;
        } else {
            c0851b = (C0851b) view.getTag();
        }
        if (this.iRv != null && i >= 0 && i < this.iRv.size()) {
            c0851b.lyO.a(this.iRv.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.lYj = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.lYk = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0851b {
        EmotionView lyO;

        C0851b() {
        }
    }
}
