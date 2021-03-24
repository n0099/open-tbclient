package com.baidu.tieba.tbadkCore.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.tbadk.core.data.RecommendTopicData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.RecomTopicList;
import tbclient.WorksInfo;
/* loaded from: classes5.dex */
public class WorksInfoData implements Serializable, Parcelable {
    public static final Parcelable.Creator<WorksInfoData> CREATOR = new a();
    public boolean isWorks;
    public List<RecommendTopicData.RecommendTopicListData> topicListData;

    /* loaded from: classes5.dex */
    public static class a implements Parcelable.Creator<WorksInfoData> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public WorksInfoData createFromParcel(Parcel parcel) {
            return new WorksInfoData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public WorksInfoData[] newArray(int i) {
            return new WorksInfoData[i];
        }
    }

    public WorksInfoData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.isWorks = jSONObject.optInt("is_works") == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray("topic_list");
        if (optJSONArray != null) {
            this.topicListData = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                RecommendTopicData.RecommendTopicListData recommendTopicListData = new RecommendTopicData.RecommendTopicListData();
                recommendTopicListData.parseJson(optJSONArray.optJSONObject(i));
                this.topicListData.add(recommendTopicListData);
            }
        }
    }

    public void parseProto(WorksInfo worksInfo) {
        if (worksInfo == null) {
            return;
        }
        this.isWorks = worksInfo.is_works.intValue() == 1;
        if (worksInfo.topic_list != null) {
            this.topicListData = new ArrayList();
            for (RecomTopicList recomTopicList : worksInfo.topic_list) {
                RecommendTopicData.RecommendTopicListData recommendTopicListData = new RecommendTopicData.RecommendTopicListData();
                recommendTopicListData.parserProtoBuf(recomTopicList);
                this.topicListData.add(recommendTopicListData);
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.isWorks ? (byte) 1 : (byte) 0);
        parcel.writeList(this.topicListData);
    }

    public WorksInfoData(Parcel parcel) {
        this.isWorks = parcel.readByte() != 0;
        ArrayList arrayList = new ArrayList();
        this.topicListData = arrayList;
        parcel.readList(arrayList, RecommendTopicData.RecommendTopicListData.class.getClassLoader());
    }
}
