package com.baidu.tieba.tbadkCore.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.Agree;
/* loaded from: classes5.dex */
public class AgreeData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long agreeNum;
    public int agreeType;
    public BaijiahaoData baijiahaoData;
    public int cardType;
    public long diffAgreeNum;
    public long disAgreeNum;
    public String forumId;
    public boolean hasAgree;
    public long indexOfPic;
    public boolean isFromImageViewer;
    public boolean isInPost;
    public boolean isInThread;
    public String keyFromHomePage;
    public String mImageViewerFromPage;
    public String nid;
    public String objSource;
    public int objType;
    public String postId;
    public String recomAbTag;
    public String recomExtra;
    public String recomSource;
    public String recomWeight;
    public String threadId;

    public AgreeData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.diffAgreeNum = 0L;
        this.agreeNum = 0L;
        this.disAgreeNum = 0L;
        this.hasAgree = false;
        this.threadId = "";
        this.forumId = "";
        this.postId = "";
        this.isInThread = false;
        this.objType = 0;
        this.isInPost = false;
        this.indexOfPic = 0L;
    }

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.agreeNum = jSONObject.optInt("agree_num");
        this.disAgreeNum = jSONObject.optLong("disagree_num");
        this.agreeType = jSONObject.optInt("agree_type");
        boolean z = true;
        if (jSONObject.optInt("has_agree") != 1) {
            z = false;
        }
        this.hasAgree = z;
        this.diffAgreeNum = jSONObject.optLong("diff_agree_num");
    }

    public void parseProtobuf(Agree agree) {
        long longValue;
        int intValue;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, agree) != null) || agree == null) {
            return;
        }
        Long l = agree.agree_num;
        long j = 0;
        if (l == null) {
            longValue = 0;
        } else {
            longValue = l.longValue();
        }
        this.agreeNum = longValue;
        this.disAgreeNum = agree.disagree_num.longValue();
        Integer num = agree.agree_type;
        boolean z = false;
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        this.agreeType = intValue;
        if (agree.has_agree.intValue() == 1) {
            z = true;
        }
        this.hasAgree = z;
        Long l2 = agree.diff_agree_num;
        if (l2 != null) {
            j = l2.longValue();
        }
        this.diffAgreeNum = j;
    }
}
