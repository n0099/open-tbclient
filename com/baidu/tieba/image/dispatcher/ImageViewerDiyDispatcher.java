package com.baidu.tieba.image.dispatcher;

import android.util.TypedValue;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tieba.s7a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ImageViewerDiyDispatcher implements s7a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ImageViewerDiyDispatcher() {
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

    private int changeToPx(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65537, this, f)) == null) {
            return (int) TypedValue.applyDimension(1, f, SelectorHelper.getResources().getDisplayMetrics());
        }
        return invokeF.intValue;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:59:0x013b
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.baidu.tieba.s7a
    public void dispatch(org.json.JSONObject r23, android.content.Context r24) {
        /*
            r22 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.image.dispatcher.ImageViewerDiyDispatcher.$ic
            if (r0 != 0) goto L249
        L4:
            r1 = r22
            r0 = r23
            r2 = r24
            if (r0 == 0) goto L248
            if (r2 != 0) goto L10
            goto L248
        L10:
            java.lang.String r3 = "index"
            java.lang.String r3 = r0.optString(r3)
            r4 = -1
            int r3 = com.baidu.adp.lib.safe.JavaTypesHelper.toInt(r3, r4)
            java.lang.String r4 = "enterType"
            r0.optString(r4)
            java.lang.String r4 = "forbidAd"
            java.lang.String r4 = r0.optString(r4)
            r5 = 1
            int r4 = com.baidu.adp.lib.safe.JavaTypesHelper.toInt(r4, r5)
            if (r4 != r5) goto L2f
            r4 = 1
            goto L30
        L2f:
            r4 = 0
        L30:
            java.lang.String r7 = "threadId"
            java.lang.String r7 = r0.optString(r7)
            java.lang.String r8 = "forumName"
            java.lang.String r8 = r0.optString(r8)
            java.lang.String r9 = "forumId"
            java.lang.String r9 = r0.optString(r9)
            java.lang.String r10 = "postId"
            java.lang.String r10 = r0.optString(r10)
            java.lang.String r11 = "title"
            r0.optString(r11)
            java.lang.String r11 = "isShowHost"
            java.lang.String r11 = r0.optString(r11)
            int r11 = com.baidu.adp.lib.safe.JavaTypesHelper.toInt(r11, r5)
            if (r11 != r5) goto L5b
            r11 = 1
            goto L5c
        L5b:
            r11 = 0
        L5c:
            java.lang.String r12 = "urls"
            org.json.JSONArray r12 = r0.optJSONArray(r12)
            java.lang.String r13 = "originPicUrls"
            org.json.JSONArray r13 = r0.optJSONArray(r13)
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            r16 = 0
            if (r12 == 0) goto L8f
            r6 = 0
        L77:
            int r5 = r12.length()     // Catch: org.json.JSONException -> L176
            if (r6 >= r5) goto L8f
            java.lang.Object r5 = r12.get(r6)     // Catch: org.json.JSONException -> L176
            java.lang.String r5 = (java.lang.String) r5     // Catch: org.json.JSONException -> L176
            boolean r17 = android.text.TextUtils.isEmpty(r5)     // Catch: org.json.JSONException -> L176
            if (r17 != 0) goto L8c
            r14.add(r5)     // Catch: org.json.JSONException -> L176
        L8c:
            int r6 = r6 + 1
            goto L77
        L8f:
            if (r13 == 0) goto Laa
            r5 = 0
        L92:
            int r6 = r13.length()     // Catch: org.json.JSONException -> L176
            if (r5 >= r6) goto Laa
            java.lang.Object r6 = r13.get(r5)     // Catch: org.json.JSONException -> L176
            java.lang.String r6 = (java.lang.String) r6     // Catch: org.json.JSONException -> L176
            boolean r12 = android.text.TextUtils.isEmpty(r6)     // Catch: org.json.JSONException -> L176
            if (r12 != 0) goto La7
            r15.add(r6)     // Catch: org.json.JSONException -> L176
        La7:
            int r5 = r5 + 1
            goto L92
        Laa:
            java.lang.String r5 = "rects"
            org.json.JSONArray r0 = r0.optJSONArray(r5)     // Catch: org.json.JSONException -> L176
            if (r0 == 0) goto L167
            int r5 = r0.length()     // Catch: org.json.JSONException -> L176
            if (r5 <= r3) goto L167
            org.json.JSONObject r5 = r0.optJSONObject(r3)     // Catch: org.json.JSONException -> L176
            if (r5 == 0) goto L167
            android.graphics.RectF r5 = new android.graphics.RectF     // Catch: org.json.JSONException -> L176
            r5.<init>()     // Catch: org.json.JSONException -> L176
            android.graphics.Rect r6 = new android.graphics.Rect     // Catch: org.json.JSONException -> L159
            r6.<init>()     // Catch: org.json.JSONException -> L159
            org.json.JSONObject r0 = r0.optJSONObject(r3)     // Catch: org.json.JSONException -> L149
            java.lang.String r12 = "l"
            r13 = r8
            r17 = r9
            r8 = 0
            r23 = r13
            double r12 = r0.optDouble(r12, r8)     // Catch: org.json.JSONException -> L143
            r18 = r11
            java.lang.String r11 = "t"
            r19 = r3
            double r2 = r0.optDouble(r11, r8)     // Catch: org.json.JSONException -> L139
            java.lang.String r11 = "w"
            r20 = r10
            double r10 = r0.optDouble(r11, r8)     // Catch: org.json.JSONException -> L135
            r21 = r4
            java.lang.String r4 = "h"
            double r8 = r0.optDouble(r4, r8)     // Catch: org.json.JSONException -> L133
            int r0 = (int) r12     // Catch: org.json.JSONException -> L133
            float r0 = (float) r0     // Catch: org.json.JSONException -> L133
            int r4 = r1.changeToPx(r0)     // Catch: org.json.JSONException -> L133
            r6.left = r4     // Catch: org.json.JSONException -> L133
            int r2 = (int) r2     // Catch: org.json.JSONException -> L133
            float r2 = (float) r2     // Catch: org.json.JSONException -> L133
            int r3 = r1.changeToPx(r2)     // Catch: org.json.JSONException -> L133
            r6.top = r3     // Catch: org.json.JSONException -> L133
            int r0 = r1.changeToPx(r0)     // Catch: org.json.JSONException -> L133
            int r3 = (int) r10     // Catch: org.json.JSONException -> L133
            float r3 = (float) r3     // Catch: org.json.JSONException -> L133
            int r3 = r1.changeToPx(r3)     // Catch: org.json.JSONException -> L133
            int r0 = r0 + r3
            r6.right = r0     // Catch: org.json.JSONException -> L133
            int r0 = r1.changeToPx(r2)     // Catch: org.json.JSONException -> L133
            int r2 = (int) r8     // Catch: org.json.JSONException -> L133
            float r2 = (float) r2     // Catch: org.json.JSONException -> L133
            int r2 = r1.changeToPx(r2)     // Catch: org.json.JSONException -> L133
            int r0 = r0 + r2
            r6.bottom = r0     // Catch: org.json.JSONException -> L133
            int r2 = r6.left     // Catch: org.json.JSONException -> L133
            float r2 = (float) r2     // Catch: org.json.JSONException -> L133
            r5.left = r2     // Catch: org.json.JSONException -> L133
            int r2 = r6.top     // Catch: org.json.JSONException -> L133
            float r2 = (float) r2     // Catch: org.json.JSONException -> L133
            r5.top = r2     // Catch: org.json.JSONException -> L133
            int r2 = r6.right     // Catch: org.json.JSONException -> L133
            float r2 = (float) r2     // Catch: org.json.JSONException -> L133
            r5.right = r2     // Catch: org.json.JSONException -> L133
            float r0 = (float) r0     // Catch: org.json.JSONException -> L133
            r5.bottom = r0     // Catch: org.json.JSONException -> L133
            r16 = r6
            goto L188
        L133:
            r0 = move-exception
            goto L156
        L135:
            r0 = move-exception
            r21 = r4
            goto L156
        L139:
            r0 = move-exception
            goto L13e
        L13b:
            r0 = move-exception
            r19 = r3
        L13e:
            r21 = r4
            r20 = r10
            goto L156
        L143:
            r0 = move-exception
            r19 = r3
            r21 = r4
            goto L152
        L149:
            r0 = move-exception
            r19 = r3
            r21 = r4
            r23 = r8
            r17 = r9
        L152:
            r20 = r10
            r18 = r11
        L156:
            r16 = r6
            goto L185
        L159:
            r0 = move-exception
            r19 = r3
            r21 = r4
            r23 = r8
            r17 = r9
            r20 = r10
            r18 = r11
            goto L185
        L167:
            r19 = r3
            r21 = r4
            r23 = r8
            r17 = r9
            r20 = r10
            r18 = r11
            r5 = r16
            goto L188
        L176:
            r0 = move-exception
            r19 = r3
            r21 = r4
            r23 = r8
            r17 = r9
            r20 = r10
            r18 = r11
            r5 = r16
        L185:
            r0.printStackTrace()
        L188:
            r0 = r16
            java.util.concurrent.ConcurrentHashMap r2 = new java.util.concurrent.ConcurrentHashMap
            r2.<init>()
            r6 = 0
        L190:
            int r3 = r14.size()
            if (r6 >= r3) goto L1e2
            java.lang.Object r3 = r14.get(r6)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L1db
            com.baidu.tbadk.coreExtra.view.ImageUrlData r3 = new com.baidu.tbadk.coreExtra.view.ImageUrlData
            r3.<init>()
            r4 = 13
            r3.urlType = r4
            java.lang.Object r4 = r14.get(r6)
            java.lang.String r4 = (java.lang.String) r4
            r3.imageUrl = r4
            int r8 = r3.urlType
            r3.urlThumbType = r8
            r3.imageThumbUrl = r4
            r8 = -1
            long r10 = com.baidu.adp.lib.safe.JavaTypesHelper.toLong(r7, r8)
            r3.threadId = r10
            r4 = r20
            long r8 = com.baidu.adp.lib.safe.JavaTypesHelper.toLong(r4, r8)
            r3.postId = r8
            java.lang.Object r8 = com.baidu.tbadk.core.util.ListUtils.getItem(r15, r6)
            java.lang.String r8 = (java.lang.String) r8
            r3.originalUrl = r8
            java.lang.Object r8 = r14.get(r6)
            java.lang.String r8 = (java.lang.String) r8
            r2.put(r8, r3)
            goto L1dd
        L1db:
            r4 = r20
        L1dd:
            int r6 = r6 + 1
            r20 = r4
            goto L190
        L1e2:
            r4 = r20
            com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder r3 = new com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder
            r3.<init>()
            com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder r6 = r3.setData(r14)
            r8 = r19
            com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder r6 = r6.setIndex(r8)
            r8 = r23
            com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder r6 = r6.setForumName(r8)
            r8 = r17
            com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder r6 = r6.setForumId(r8)
            com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder r6 = r6.setThreadId(r7)
            com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder r2 = r6.setAssistUrls(r2)
            r6 = 1
            com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder r2 = r2.setIsCDN(r6)
            com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder r2 = r2.setPostId(r4)
            com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder r2 = r2.setIsReserve(r6)
            r6 = r21
            com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder r2 = r2.setIsShowAd(r6)
            r2.setSrcRectInScreen(r0, r5)
            r2 = r24
            com.baidu.tbadk.core.atomData.ImageViewerConfig r0 = r3.bulid(r2)
            android.content.Intent r2 = r0.getIntent()
            java.lang.String r3 = "is_show_host"
            r5 = r18
            r2.putExtra(r3, r5)
            android.content.Intent r2 = r0.getIntent()
            java.lang.String r3 = "from"
            java.lang.String r4 = "other"
            r2.putExtra(r3, r4)
            com.baidu.adp.framework.MessageManager r2 = com.baidu.adp.framework.MessageManager.getInstance()
            com.baidu.adp.framework.message.CustomMessage r3 = new com.baidu.adp.framework.message.CustomMessage
            r4 = 2010000(0x1eab90, float:2.81661E-39)
            r3.<init>(r4, r0)
            r2.sendMessage(r3)
        L248:
            return
        L249:
            r20 = r0
            r21 = 1048576(0x100000, float:1.469368E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r20.invokeLL(r21, r22, r23, r24)
            if (r0 == 0) goto L4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.image.dispatcher.ImageViewerDiyDispatcher.dispatch(org.json.JSONObject, android.content.Context):void");
    }
}
