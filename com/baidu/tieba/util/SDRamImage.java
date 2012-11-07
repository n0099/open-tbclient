package com.baidu.tieba.util;

import android.graphics.Bitmap;
import com.baidu.tieba.data.Config;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class SDRamImage {
    private volatile HashMap<String, Image> photo = new HashMap<>();
    private volatile HashMap<String, Image> pic = new HashMap<>();
    private volatile int weight = 0;
    private volatile int pic_mem = 0;

    public void addPhoto(String name, Bitmap bitmap) {
        synchronized (this) {
            try {
                this.weight++;
                if (this.photo.size() >= 50) {
                    deletePhoto();
                }
                Image image = new Image(this, null);
                image.image = bitmap;
                image.weight = Integer.valueOf(this.weight);
                this.photo.put(name, image);
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "addPhoto", ex.getMessage());
            }
        }
    }

    public void addPic(String name, Bitmap bitmap, boolean isGif) {
        synchronized (this) {
            if (bitmap != null) {
                try {
                    this.weight++;
                    int pic_size = bitmap.getWidth() * bitmap.getHeight() * 2;
                    if (this.pic_mem + pic_size > Config.getBigImageMaxUsedMemory()) {
                        deletePic((this.pic_mem + pic_size) - Config.getBigImageMaxUsedMemory());
                    }
                    Image image = new Image(this, null);
                    image.image = bitmap;
                    image.weight = Integer.valueOf(this.weight);
                    image.isGif = isGif;
                    this.pic.put(name, image);
                    this.pic_mem += pic_size;
                } catch (Exception ex) {
                    TiebaLog.e(getClass().getName(), "addPic", ex.getMessage());
                }
            }
        }
    }

    public void addPic(String name, Bitmap bitmap) {
        synchronized (this) {
            if (bitmap != null) {
                try {
                    this.weight++;
                    int pic_size = bitmap.getWidth() * bitmap.getHeight() * 2;
                    if (this.pic_mem + pic_size > Config.getBigImageMaxUsedMemory()) {
                        deletePic((this.pic_mem + pic_size) - Config.getBigImageMaxUsedMemory());
                    }
                    Image image = new Image(this, null);
                    image.image = bitmap;
                    image.weight = Integer.valueOf(this.weight);
                    this.pic_mem += pic_size;
                    this.pic.put(name, image);
                } catch (Exception ex) {
                    TiebaLog.e(getClass().getName(), "addPic", ex.getMessage());
                }
            }
        }
    }

    public void deletePhoto() {
        synchronized (this) {
            String key = null;
            int tmp = 134217727;
            for (Map.Entry<String, Image> entry : this.photo.entrySet()) {
                if (entry.getValue().weight.intValue() < tmp) {
                    tmp = entry.getValue().weight.intValue();
                    key = entry.getKey();
                }
            }
            if (key != null) {
                this.photo.remove(key);
            } else {
                this.photo.clear();
            }
        }
    }

    public void deletePhoto(String key) {
        synchronized (this) {
            this.photo.remove(key);
        }
    }

    public void deletePic(int size) {
        synchronized (this) {
            if (this.pic_mem + size > Config.getBigImageMaxUsedMemory()) {
                while (size > 0) {
                    int image_size = 0;
                    String key = null;
                    int tmp = 134217727;
                    for (Map.Entry<String, Image> entry : this.pic.entrySet()) {
                        if (entry.getValue().weight.intValue() < tmp) {
                            tmp = entry.getValue().weight.intValue();
                            String key2 = entry.getKey();
                            key = key2;
                        }
                    }
                    if (key != null) {
                        Image image = this.pic.remove(key);
                        if (this.pic != null && image.image != null) {
                            image_size = image.image.getWidth() * image.image.getHeight() * 2;
                            this.pic_mem -= image_size;
                            size -= image_size;
                        }
                    } else {
                        this.pic.clear();
                        this.pic_mem = 0;
                        size = 0;
                    }
                    size -= image_size;
                }
            }
        }
    }

    public Bitmap getPhoto(String name) {
        Bitmap bitmap;
        synchronized (this) {
            bitmap = null;
            Image image = this.photo.get(name);
            if (image != null) {
                this.weight++;
                bitmap = image.image;
                image.weight = Integer.valueOf(this.weight);
            }
        }
        return bitmap;
    }

    public Bitmap getPic(String name) {
        Bitmap bitmap;
        synchronized (this) {
            bitmap = null;
            Image image = this.pic.get(name);
            if (image != null) {
                this.weight++;
                bitmap = image.image;
                image.weight = Integer.valueOf(this.weight);
            }
        }
        return bitmap;
    }

    public boolean isGif(String name) {
        boolean isGif;
        synchronized (this) {
            isGif = false;
            Image image = this.pic.get(name);
            if (image != null) {
                isGif = image.isGif;
            }
        }
        return isGif;
    }

    public void clearPicAndPhoto() {
        synchronized (this) {
            this.photo.clear();
            this.pic.clear();
            this.pic_mem = 0;
        }
    }

    public void LogCount() {
        int photo_size = this.photo.size();
        int i = 0;
        TiebaLog.log_e(0, getClass().getName(), "logPrint", "photo.size = " + String.valueOf(photo_size));
        for (Map.Entry<String, Image> entry : this.photo.entrySet()) {
            StringBuffer log = new StringBuffer(50);
            log.append("photo[");
            log.append(i);
            log.append("].width = ");
            log.append(entry.getValue().image.getWidth());
            log.append("\tphoto[");
            log.append(i);
            log.append("].height = ");
            log.append(entry.getValue().image.getHeight());
            TiebaLog.log_e(0, getClass().getName(), "logPrint", log.toString());
            i++;
        }
        int pic_size = this.pic.size();
        int i2 = 0;
        TiebaLog.log_e(0, getClass().getName(), "logPrint", "pic.size = " + String.valueOf(pic_size));
        for (Map.Entry<String, Image> entry2 : this.pic.entrySet()) {
            StringBuffer log2 = new StringBuffer(50);
            log2.append("pic[");
            log2.append(i2);
            log2.append("].width = ");
            log2.append(entry2.getValue().image.getWidth());
            log2.append("\tpic[");
            log2.append(i2);
            log2.append("].height = ");
            log2.append(entry2.getValue().image.getHeight());
            TiebaLog.log_e(0, getClass().getName(), "logPrint", log2.toString());
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class Image {
        Bitmap image;
        boolean isGif;
        Integer weight;

        private Image() {
        }

        /* synthetic */ Image(SDRamImage sDRamImage, Image image) {
            this();
        }
    }
}
