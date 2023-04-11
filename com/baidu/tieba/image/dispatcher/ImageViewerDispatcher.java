package com.baidu.tieba.image.dispatcher;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tieba.xc9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ImageViewerDispatcher implements xc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ImageViewerDispatcher() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.xc9
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dispatch(JSONObject jSONObject, Context context) {
        String str;
        String str2;
        JSONObject optJSONObject;
        boolean z;
        String str3;
        boolean z2;
        boolean z3;
        long longValue;
        long longValue2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && context != null && jSONObject != null) {
            Long valueOf = Long.valueOf(jSONObject.optLong("tid"));
            int optInt = jSONObject.optInt("index");
            String optString = jSONObject.optString("fname");
            String optString2 = jSONObject.optString("fid");
            String optString3 = jSONObject.optString("from");
            String optString4 = jSONObject.optString("title");
            String optString5 = jSONObject.optString("first_floor_id");
            JSONArray optJSONArray = jSONObject.optJSONArray("pic_data_list");
            ArrayList<String> arrayList = new ArrayList<>();
            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i = 0;
                while (i < optJSONArray.length()) {
                    try {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i);
                        arrayList.add(jSONObject2.optString("big_pic_url"));
                        ImageUrlData imageUrlData = new ImageUrlData();
                        JSONArray jSONArray = optJSONArray;
                        imageUrlData.urlType = 13;
                        imageUrlData.imageUrl = jSONObject2.optString("small_pic_url");
                        imageUrlData.originalUrl = jSONObject2.optString("origin_pic_url");
                        str = optString4;
                        str2 = optString5;
                        try {
                            imageUrlData.originalSize = jSONObject2.optLong("origin_pic_size");
                            if (jSONObject2.optInt("is_long_pic") == 1) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            imageUrlData.isLongPic = z2;
                            if (jSONObject2.optInt("is_show_origin_btn") == 1) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            imageUrlData.mIsShowOrigonButton = z3;
                            if (valueOf == null) {
                                longValue = 0;
                            } else {
                                longValue = valueOf.longValue();
                            }
                            imageUrlData.threadId = longValue;
                            Long valueOf2 = Long.valueOf(jSONObject2.optLong(WriteActivityConfig.FLOOR_ID));
                            if (valueOf2 == null) {
                                longValue2 = 0;
                            } else {
                                longValue2 = valueOf2.longValue();
                            }
                            imageUrlData.postId = longValue2;
                            concurrentHashMap.put(arrayList.get(i), imageUrlData);
                            i++;
                            optJSONArray = jSONArray;
                            optString4 = str;
                            optString5 = str2;
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            JSONObject optJSONObject2 = jSONObject.optJSONObject("rect");
                            Rect rect = new Rect();
                            RectF rectF = new RectF();
                            rect.left = optJSONObject2.optInt("l");
                            rect.top = optJSONObject2.optInt("t");
                            rect.right = optJSONObject2.optInt("r");
                            int optInt2 = optJSONObject2.optInt("b");
                            rect.bottom = optInt2;
                            rectF.left = rect.left;
                            rectF.top = rect.top;
                            rectF.right = rect.right;
                            rectF.bottom = optInt2;
                            ThreadData threadData = null;
                            optJSONObject = jSONObject.optJSONObject("recom_info");
                            if (optJSONObject != null) {
                            }
                            ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                            builder.A(arrayList);
                            builder.E(optInt);
                            builder.C(optString);
                            builder.B(optString2);
                            builder.R(String.valueOf(valueOf));
                            builder.F(true);
                            if (arrayList.size() <= 0) {
                            }
                            builder.M(str3);
                            builder.I(true);
                            builder.y(concurrentHashMap);
                            builder.K(true);
                            builder.Q(threadData);
                            builder.H(z);
                            builder.P(rect, rectF);
                            ImageViewerConfig x = builder.x(context);
                            if (optString3 != null) {
                            }
                            BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect(ImageViewerConfig.KEY_FPS_IMAGE_FROM, "image", "tran");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, x));
                            if (!(context instanceof TbPageContextSupport)) {
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = optString4;
                        str2 = optString5;
                    }
                }
            }
            str = optString4;
            str2 = optString5;
            JSONObject optJSONObject22 = jSONObject.optJSONObject("rect");
            Rect rect2 = new Rect();
            RectF rectF2 = new RectF();
            rect2.left = optJSONObject22.optInt("l");
            rect2.top = optJSONObject22.optInt("t");
            rect2.right = optJSONObject22.optInt("r");
            int optInt22 = optJSONObject22.optInt("b");
            rect2.bottom = optInt22;
            rectF2.left = rect2.left;
            rectF2.top = rect2.top;
            rectF2.right = rect2.right;
            rectF2.bottom = optInt22;
            ThreadData threadData2 = null;
            optJSONObject = jSONObject.optJSONObject("recom_info");
            if (optJSONObject != null) {
                threadData2 = new ThreadData();
                threadData2.recomCardType = optJSONObject.optInt("card_type");
                threadData2.mRecomSource = optJSONObject.optString("source");
                threadData2.mRecomAbTag = optJSONObject.optString("ab_tag");
                threadData2.mRecomWeight = optJSONObject.optString("weight");
                threadData2.mRecomExtra = optJSONObject.optString("extra");
            }
            ImageViewerConfig.Builder builder2 = new ImageViewerConfig.Builder();
            builder2.A(arrayList);
            builder2.E(optInt);
            builder2.C(optString);
            builder2.B(optString2);
            builder2.R(String.valueOf(valueOf));
            builder2.F(true);
            if (arrayList.size() <= 0) {
                z = false;
                str3 = arrayList.get(0);
            } else {
                z = false;
                str3 = "";
            }
            builder2.M(str3);
            builder2.I(true);
            builder2.y(concurrentHashMap);
            builder2.K(true);
            builder2.Q(threadData2);
            builder2.H(z);
            builder2.P(rect2, rectF2);
            ImageViewerConfig x2 = builder2.x(context);
            if (optString3 != null) {
                x2.getIntent().putExtra("from", optString3);
            }
            BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect(ImageViewerConfig.KEY_FPS_IMAGE_FROM, "image", "tran");
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, x2));
            if (!(context instanceof TbPageContextSupport)) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = ((TbPageContextSupport) context).getPageContext();
                historyMessage.threadId = String.valueOf(valueOf);
                historyMessage.threadName = str;
                historyMessage.forumName = optString;
                historyMessage.postID = str2;
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
        }
    }
}
