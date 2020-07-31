package com.baidubce.util;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidubce.BceErrorResponse;
import com.baidubce.http.BceHttpResponse;
import com.baidubce.model.AbstractBceResponse;
import com.baidubce.model.User;
import com.baidubce.services.bos.model.BosObjectSummary;
import com.baidubce.services.bos.model.BucketSummary;
import com.baidubce.services.bos.model.CompleteMultipartUploadResponse;
import com.baidubce.services.bos.model.CopyObjectResponse;
import com.baidubce.services.bos.model.CopyObjectResponseWithExceptionInfo;
import com.baidubce.services.bos.model.GetBucketAclResponse;
import com.baidubce.services.bos.model.GetBucketLocationResponse;
import com.baidubce.services.bos.model.Grant;
import com.baidubce.services.bos.model.Grantee;
import com.baidubce.services.bos.model.InitiateMultipartUploadResponse;
import com.baidubce.services.bos.model.ListBucketsResponse;
import com.baidubce.services.bos.model.ListMultipartUploadsResponse;
import com.baidubce.services.bos.model.ListObjectsResponse;
import com.baidubce.services.bos.model.ListPartsResponse;
import com.baidubce.services.bos.model.MultipartUploadSummary;
import com.baidubce.services.bos.model.PartETag;
import com.baidubce.services.bos.model.PartSummary;
import com.baidubce.services.bos.model.Permission;
import com.baidubce.services.sts.model.GetSessionTokenResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class JsonUtils {
    public static void loadFromString(String str, AbstractBceResponse abstractBceResponse) throws IOException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, JSONException, ParseException {
        JSONObject jSONObject = new JSONObject(str);
        if (abstractBceResponse.getClass() == ListBucketsResponse.class) {
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString("owner"));
            User user = new User();
            user.setDisplayName(jSONObject2.getString("displayName"));
            user.setId(jSONObject2.getString("id"));
            JSONArray jSONArray = jSONObject.getJSONArray("buckets");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                BucketSummary bucketSummary = new BucketSummary();
                bucketSummary.setName(optJSONObject.getString("name"));
                bucketSummary.setLocation(optJSONObject.getString("location"));
                bucketSummary.setCreationDate(DateUtils.parseAlternateIso8601Date(optJSONObject.getString("creationDate")));
                arrayList.add(bucketSummary);
            }
            abstractBceResponse.getClass().getMethod("setOwner", User.class).invoke(abstractBceResponse, user);
            abstractBceResponse.getClass().getMethod("setBuckets", List.class).invoke(abstractBceResponse, arrayList);
        } else if (abstractBceResponse.getClass() == ListObjectsResponse.class) {
            abstractBceResponse.getClass().getMethod("setBucketName", String.class).invoke(abstractBceResponse, jSONObject.getString("name"));
            abstractBceResponse.getClass().getMethod("setMarker", String.class).invoke(abstractBceResponse, jSONObject.getString("marker"));
            if (jSONObject.has("nextMarker")) {
                abstractBceResponse.getClass().getMethod("setNextMarker", String.class).invoke(abstractBceResponse, jSONObject.getString("nextMarker"));
            }
            abstractBceResponse.getClass().getMethod("setMaxKeys", Integer.TYPE).invoke(abstractBceResponse, Integer.valueOf(jSONObject.getInt("maxKeys")));
            if (jSONObject.has("prefix")) {
                abstractBceResponse.getClass().getMethod("setPrefix", String.class).invoke(abstractBceResponse, jSONObject.getString("prefix"));
            }
            if (jSONObject.has("delimiter")) {
                abstractBceResponse.getClass().getMethod("setDelimiter", String.class).invoke(abstractBceResponse, jSONObject.getString("delimiter"));
            }
            abstractBceResponse.getClass().getMethod("setTruncated", Boolean.TYPE).invoke(abstractBceResponse, Boolean.valueOf(jSONObject.getBoolean("isTruncated")));
            if (jSONObject.has("commonPrefixes")) {
                Method method = abstractBceResponse.getClass().getMethod("setCommonPrefixes", List.class);
                JSONArray jSONArray2 = jSONObject.getJSONArray("commonPrefixes");
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    arrayList2.add(jSONArray2.optJSONObject(i2).getString("prefix"));
                }
                method.invoke(abstractBceResponse, arrayList2);
            }
            JSONArray jSONArray3 = jSONObject.getJSONArray("contents");
            if (jSONArray3.length() > 0) {
                ArrayList arrayList3 = new ArrayList();
                for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                    JSONObject optJSONObject2 = jSONArray3.optJSONObject(i3);
                    BosObjectSummary bosObjectSummary = new BosObjectSummary();
                    bosObjectSummary.setETag(optJSONObject2.getString("eTag"));
                    bosObjectSummary.setKey(optJSONObject2.getString("key"));
                    bosObjectSummary.setSize(optJSONObject2.getLong(TiebaInitialize.LogFields.SIZE));
                    bosObjectSummary.setLastModified(DateUtils.parseAlternateIso8601Date(optJSONObject2.getString("lastModified")));
                    bosObjectSummary.setStorageClass(optJSONObject2.getString("storageClass"));
                    JSONObject jSONObject3 = optJSONObject2.getJSONObject("owner");
                    User user2 = new User();
                    user2.setId(jSONObject3.getString("id"));
                    user2.setDisplayName(jSONObject3.getString("displayName"));
                    bosObjectSummary.setOwner(user2);
                    arrayList3.add(bosObjectSummary);
                }
                abstractBceResponse.getClass().getMethod("setContents", List.class).invoke(abstractBceResponse, arrayList3);
            }
        } else if (abstractBceResponse.getClass() == GetBucketAclResponse.class) {
            JSONObject jSONObject4 = new JSONObject(jSONObject.getString("owner"));
            Grantee grantee = new Grantee();
            grantee.setId(jSONObject4.getString("id"));
            abstractBceResponse.getClass().getMethod("setOwner", Grantee.class).invoke(abstractBceResponse, grantee);
            JSONArray jSONArray4 = jSONObject.getJSONArray("accessControlList");
            ArrayList arrayList4 = new ArrayList();
            for (int i4 = 0; i4 < jSONArray4.length(); i4++) {
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                JSONObject jSONObject5 = new JSONObject(jSONArray4.optJSONObject(i4).toString());
                JSONArray jSONArray5 = jSONObject5.getJSONArray("grantee");
                for (int i5 = 0; i5 < jSONArray5.length(); i5++) {
                    JSONObject optJSONObject3 = jSONArray5.optJSONObject(i5);
                    Grantee grantee2 = new Grantee();
                    grantee2.setId(optJSONObject3.getString("id"));
                    arrayList5.add(grantee2);
                }
                JSONArray jSONArray6 = jSONObject5.getJSONArray("permission");
                for (int i6 = 0; i6 < jSONArray6.length(); i6++) {
                    switch (Permission.valueOf(jSONArray6.get(i6).toString())) {
                        case FULL_CONTROL:
                            arrayList6.add(Permission.FULL_CONTROL);
                            break;
                        case READ:
                            arrayList6.add(Permission.READ);
                            break;
                        case WRITE:
                            arrayList6.add(Permission.WRITE);
                            break;
                    }
                }
                arrayList4.add(new Grant(arrayList5, arrayList6));
            }
            abstractBceResponse.getClass().getMethod("setAccessControlList", List.class).invoke(abstractBceResponse, arrayList4);
        } else if (abstractBceResponse.getClass() == CopyObjectResponse.class) {
            abstractBceResponse.getClass().getMethod("setLastModified", Date.class).invoke(abstractBceResponse, DateUtils.parseAlternateIso8601Date(String.valueOf(jSONObject.get("lastModified"))));
            abstractBceResponse.getClass().getMethod("setETag", String.class).invoke(abstractBceResponse, jSONObject.get("eTag"));
        } else if (abstractBceResponse.getClass() == CopyObjectResponseWithExceptionInfo.class) {
            abstractBceResponse.getClass().getMethod("setLastModified", Date.class).invoke(abstractBceResponse, DateUtils.parseAlternateIso8601Date(String.valueOf(jSONObject.get("lastModified"))));
            abstractBceResponse.getClass().getMethod("setETag", String.class).invoke(abstractBceResponse, jSONObject.get("eTag"));
        } else if (abstractBceResponse.getClass() == InitiateMultipartUploadResponse.class) {
            abstractBceResponse.getClass().getMethod("setBucketName", String.class).invoke(abstractBceResponse, jSONObject.get("bucket"));
            abstractBceResponse.getClass().getMethod("setKey", String.class).invoke(abstractBceResponse, jSONObject.get("key"));
            abstractBceResponse.getClass().getMethod("setUploadId", String.class).invoke(abstractBceResponse, jSONObject.get("uploadId"));
        } else if (abstractBceResponse.getClass() == CompleteMultipartUploadResponse.class) {
            abstractBceResponse.getClass().getMethod("setBucketName", String.class).invoke(abstractBceResponse, jSONObject.get("bucket"));
            abstractBceResponse.getClass().getMethod("setKey", String.class).invoke(abstractBceResponse, jSONObject.get("key"));
            abstractBceResponse.getClass().getMethod("setLocation", String.class).invoke(abstractBceResponse, jSONObject.get("location"));
            abstractBceResponse.getClass().getMethod("setETag", String.class).invoke(abstractBceResponse, jSONObject.get("eTag"));
        } else if (abstractBceResponse.getClass() == ListMultipartUploadsResponse.class) {
            abstractBceResponse.getClass().getMethod("setBucketName", String.class).invoke(abstractBceResponse, jSONObject.get("bucket"));
            if (jSONObject.has("keyMarker")) {
                abstractBceResponse.getClass().getMethod("setKeyMarker", String.class).invoke(abstractBceResponse, jSONObject.get("keyMarker"));
            }
            if (jSONObject.has("nextKeyMarker")) {
                abstractBceResponse.getClass().getMethod("setNextKeyMarker", String.class).invoke(abstractBceResponse, jSONObject.get("nextKeyMarker"));
            }
            abstractBceResponse.getClass().getMethod("setMaxUploads", Integer.TYPE).invoke(abstractBceResponse, jSONObject.get("maxUploads"));
            abstractBceResponse.getClass().getMethod("setPrefix", String.class).invoke(abstractBceResponse, jSONObject.get("prefix"));
            if (jSONObject.has("delimiter")) {
                abstractBceResponse.getClass().getMethod("setDelimiter", String.class).invoke(abstractBceResponse, jSONObject.get("delimiter"));
            }
            abstractBceResponse.getClass().getMethod("setTruncated", Boolean.TYPE).invoke(abstractBceResponse, jSONObject.get("isTruncated"));
            if (jSONObject.has("commonPrefixes")) {
                Method method2 = abstractBceResponse.getClass().getMethod("setCommonPrefixes", List.class);
                JSONArray jSONArray7 = jSONObject.getJSONArray("commonPrefixes");
                ArrayList arrayList7 = new ArrayList();
                for (int i7 = 0; i7 < jSONArray7.length(); i7++) {
                    arrayList7.add(jSONArray7.optJSONObject(i7).getString("prefix"));
                }
                method2.invoke(abstractBceResponse, arrayList7);
            }
            ArrayList arrayList8 = new ArrayList();
            JSONArray jSONArray8 = jSONObject.getJSONArray("uploads");
            for (int i8 = 0; i8 < jSONArray8.length(); i8++) {
                JSONObject optJSONObject4 = jSONArray8.optJSONObject(i8);
                MultipartUploadSummary multipartUploadSummary = new MultipartUploadSummary();
                multipartUploadSummary.setUploadId(optJSONObject4.getString("uploadId"));
                multipartUploadSummary.setKey(optJSONObject4.getString("key"));
                multipartUploadSummary.setInitiated(DateUtils.parseAlternateIso8601Date(optJSONObject4.getString("initiated")));
                multipartUploadSummary.setStorageClass(optJSONObject4.getString("storageClass"));
                JSONObject jSONObject6 = optJSONObject4.getJSONObject("owner");
                User user3 = new User();
                user3.setId(jSONObject6.getString("id"));
                user3.setDisplayName(jSONObject6.getString("displayName"));
                multipartUploadSummary.setOwner(user3);
                arrayList8.add(multipartUploadSummary);
            }
            abstractBceResponse.getClass().getMethod("setMultipartUploads", List.class).invoke(abstractBceResponse, arrayList8);
        } else if (abstractBceResponse.getClass() == ListPartsResponse.class) {
            abstractBceResponse.getClass().getMethod("setBucketName", String.class).invoke(abstractBceResponse, jSONObject.get("bucket"));
            abstractBceResponse.getClass().getMethod("setKey", String.class).invoke(abstractBceResponse, jSONObject.get("key"));
            abstractBceResponse.getClass().getMethod("setUploadId", String.class).invoke(abstractBceResponse, jSONObject.get("uploadId"));
            abstractBceResponse.getClass().getMethod("setInitiated", Date.class).invoke(abstractBceResponse, DateUtils.parseAlternateIso8601Date(jSONObject.getString("initiated")));
            abstractBceResponse.getClass().getMethod("setStorageClass", String.class).invoke(abstractBceResponse, jSONObject.get("storageClass"));
            abstractBceResponse.getClass().getMethod("setPartNumberMarker", Integer.TYPE).invoke(abstractBceResponse, jSONObject.get("partNumberMarker"));
            abstractBceResponse.getClass().getMethod("setNextPartNumberMarker", Integer.TYPE).invoke(abstractBceResponse, jSONObject.get("nextPartNumberMarker"));
            abstractBceResponse.getClass().getMethod("setMaxParts", Integer.TYPE).invoke(abstractBceResponse, Integer.valueOf(jSONObject.getInt("maxParts")));
            abstractBceResponse.getClass().getMethod("setTruncated", Boolean.TYPE).invoke(abstractBceResponse, jSONObject.get("isTruncated"));
            JSONObject jSONObject7 = new JSONObject(jSONObject.getString("owner"));
            User user4 = new User();
            user4.setDisplayName(jSONObject7.getString("displayName"));
            user4.setId(jSONObject7.getString("id"));
            abstractBceResponse.getClass().getMethod("setOwner", User.class).invoke(abstractBceResponse, user4);
            ArrayList arrayList9 = new ArrayList();
            JSONArray jSONArray9 = jSONObject.getJSONArray("parts");
            for (int i9 = 0; i9 < jSONArray9.length(); i9++) {
                JSONObject optJSONObject5 = jSONArray9.optJSONObject(i9);
                PartSummary partSummary = new PartSummary();
                partSummary.setPartNumber(optJSONObject5.getInt("partNumber"));
                partSummary.setETag(optJSONObject5.getString("eTag"));
                partSummary.setSize(optJSONObject5.getInt(TiebaInitialize.LogFields.SIZE));
                partSummary.setLastModified(DateUtils.parseAlternateIso8601Date(optJSONObject5.getString("lastModified")));
                arrayList9.add(partSummary);
            }
            abstractBceResponse.getClass().getMethod("setParts", List.class).invoke(abstractBceResponse, arrayList9);
        } else if (abstractBceResponse.getClass() == GetSessionTokenResponse.class) {
            abstractBceResponse.getClass().getMethod("setAccessKeyId", String.class).invoke(abstractBceResponse, jSONObject.get("accessKeyId"));
            abstractBceResponse.getClass().getMethod("setSecretAccessKey", String.class).invoke(abstractBceResponse, jSONObject.get("secretAccessKey"));
            abstractBceResponse.getClass().getMethod("setSessionToken", String.class).invoke(abstractBceResponse, jSONObject.get("sessionToken"));
            abstractBceResponse.getClass().getMethod("setExpiration", Date.class).invoke(abstractBceResponse, DateUtils.parseAlternateIso8601Date(jSONObject.getString("expiration")));
        } else if (abstractBceResponse.getClass() == GetBucketLocationResponse.class) {
            abstractBceResponse.getClass().getMethod("setLocationConstraint", String.class).invoke(abstractBceResponse, jSONObject.get("locationConstraint"));
        }
    }

    public static void load(BceHttpResponse bceHttpResponse, AbstractBceResponse abstractBceResponse) throws IOException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, JSONException, ParseException {
        load(bceHttpResponse.getContent(), abstractBceResponse);
    }

    public static void load(InputStream inputStream, AbstractBceResponse abstractBceResponse) throws IOException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, JSONException, ParseException {
        String str = "";
        if (inputStream != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    str = str + readLine;
                } else {
                    inputStream.close();
                    loadFromString(str, abstractBceResponse);
                    return;
                }
            }
        }
    }

    public static BceErrorResponse loadError(InputStream inputStream) throws IOException, JSONException {
        BceErrorResponse bceErrorResponse = new BceErrorResponse();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = "";
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            str = str + readLine;
        }
        if (str.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        bceErrorResponse.setCode(jSONObject.getString("code"));
        bceErrorResponse.setMessage(jSONObject.getString("message"));
        bceErrorResponse.setRequestId(jSONObject.getString("requestId"));
        return bceErrorResponse;
    }

    public static String setAclJson(List<Grant> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        for (Grant grant : list) {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            for (Permission permission : grant.getPermission()) {
                jSONArray2.put(permission.toString());
            }
            jSONObject2.put("permission", jSONArray2);
            JSONArray jSONArray3 = new JSONArray();
            for (Grantee grantee : grant.getGrantee()) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", grantee.getId());
                jSONArray3.put(jSONObject3);
            }
            jSONObject2.put("grantee", jSONArray3);
            jSONArray.put(jSONObject2);
        }
        jSONObject.put("accessControlList", jSONArray);
        return jSONObject.toString();
    }

    public static String setPartETag(List<PartETag> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        for (PartETag partETag : list) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("eTag", partETag.getETag());
            jSONObject2.put("partNumber", partETag.getPartNumber());
            jSONArray.put(jSONObject2);
        }
        jSONObject.put("parts", jSONArray);
        return jSONObject.toString();
    }
}
